package msg;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;
import java.time.LocalDateTime;

public class BuyerAgent extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if(msg!=null){
                    JOptionPane.showMessageDialog(null, msg.getContent());
                }else block();

            }
        });
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                LocalDateTime dateTime = LocalDateTime.now();
                msg2.setContent("5 - Enviando informações de compra até agente notificador - " + dateTime);
                msg2.addReceiver(new AID("notifying", AID.ISLOCALNAME));
                send(msg2);
            }
        });
    }
}
