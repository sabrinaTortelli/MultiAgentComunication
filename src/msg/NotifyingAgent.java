package msg;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

public class NotifyingAgent extends Agent {

    private ACLMessage msg;

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                msg = receive();
                if(msg!=null){
                    JOptionPane.showMessageDialog(null, msg.getContent());
                }else block();

            }
        });
    }
}
