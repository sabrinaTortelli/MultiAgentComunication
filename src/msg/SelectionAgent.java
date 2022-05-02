package msg;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.time.LocalDateTime;

public class SelectionAgent extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                LocalDateTime dateTime = LocalDateTime.now();
                msg.setContent("1 - Enviando farmácias selecionadas - " + dateTime);
                msg.addReceiver(new AID("comparation", AID.ISLOCALNAME));
                send(msg);
            }
        });
    }
}
