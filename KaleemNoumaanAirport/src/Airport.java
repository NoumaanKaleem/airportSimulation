// Noumaan Kaleem - ICS4U - Airport Simulation Assignment

/** This program runs a simulation of flights with their respective flight numbers; the flights land and take off which is displayed to the user in consistent timings.
 * For every two flights that land, one flight takes off.
 * The user can choose to add flight numbers to each of the queues, and the program runs until the user exits the program.
*/

// import required libraries
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author Noumaan Kaleem
 */
public class Airport extends javax.swing.JFrame {

    // initialize landing and takeoff queues
    public static Queue<Integer> landing = new LinkedList<Integer>();
    public static Queue<Integer> takeOff = new LinkedList<Integer>();
    // initialize counter for time
    int counter = 0;
    // initialize counter for arrivals
    int arrivalsCount = 0;
    // intialize timer duration
    int tDuration = 600;
    // initialize timer object
    Timer t = new Timer(tDuration, new TimerListener());
    // initialize booleans if the program is doing the arrivals or take offs
    boolean doingArrivals = false;
    boolean doingTakeOffs = false;
    // boolean if any arrivals or takeoff flights were added to the queue
    boolean arrivalsAdded = false;
    boolean takeOffAdded = false;

    /**
     * Creates new form Airport
     */
    public Airport() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        updateLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        arrivingField = new javax.swing.JTextField();
        takeoffField = new javax.swing.JTextField();
        exitBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        takeoffText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        arrivalsText = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startBtn.setText("START");
        startBtn.setFocusable(false);
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Arrivals");

        jLabel2.setText("Takeoffs");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Airport Simulator (KAL)");

        updateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateLabel.setText("Press 'START' to begin simulation.");

        jLabel5.setText("Arriving Flight:");

        jLabel6.setText("Takeoff Flight:");

        arrivingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivingFieldActionPerformed(evt);
            }
        });

        takeoffField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeoffFieldActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        takeoffText.setEditable(false);
        takeoffText.setColumns(20);
        takeoffText.setRows(5);
        takeoffText.setFocusable(false);
        jScrollPane1.setViewportView(takeoffText);

        arrivalsText.setEditable(false);
        arrivalsText.setColumns(20);
        arrivalsText.setRows(5);
        arrivalsText.setFocusable(false);
        jScrollPane2.setViewportView(arrivalsText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(161, 161, 161)
                            .addComponent(jLabel2))
                        .addComponent(updateLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrivingField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(takeoffField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(102, 102, 102)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(updateLabel)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(startBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(arrivingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(takeoffField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        // When the start button is clicked, start the timer
        t.start();
    }//GEN-LAST:event_startBtnActionPerformed

    private void arrivingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivingFieldActionPerformed

        // if the user presses enter in the arrivals field
        try {
            // convert to integer and add it to the landing queue
            landing.add(Integer.parseInt(arrivingField.getText()));
            // set arrivals added to true
            arrivalsAdded = true;
            // call updatequeue method
            updateQueue(landing);
            // set arrivals added to false;
            arrivalsAdded = false;
            // clear the text field
            arrivingField.setText("");
            // clear error label
            errorLabel.setText("");

            // if the user enters something other than an integer
        } catch (NumberFormatException e) {
            // display that only integers should be entered
            errorLabel.setText("Only enter integers into the text fields.");
            // clear the label
            arrivingField.setText("");
        }
    }//GEN-LAST:event_arrivingFieldActionPerformed

    private void takeoffFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeoffFieldActionPerformed
        // TODO add your handling code here:

        try {
            // convert to integer and add it to the takeOff queue
            takeOff.add(Integer.parseInt(takeoffField.getText()));
            // set takeOff added to true
            takeOffAdded = true;
            // call updatequeue method
            updateQueue(takeOff);
            // set takeOff added to false;
            takeOffAdded = false;
            // clear the text field
            takeoffField.setText("");
            // clear error label
            errorLabel.setText("");
            // if the user enters something other than an integer
        } catch (NumberFormatException e) {
            // display that user should only enter integers
            errorLabel.setText("Only enter integers into the text fields.");
            // clear the text field
            takeoffField.setText("");
        }
    }//GEN-LAST:event_takeoffFieldActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // Closes the program when the exit button is pressed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Airport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Airport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Airport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Airport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // when program is run
                new Airport().setVisible(true);
                // call file read method
                fileRead();
                // call method to display queue in text areas
                output();

            }
        });
    }

    // method to display queues in text areas
    public static void output() {
        // initialize a string for flight numbers that will be displayed on text area
        String arrivalsFlight = "";
        // iterate over the landings queue
        for (int numArrivals : landing) {
            // set the string to the current string plus the current queue element
            arrivalsFlight = arrivalsFlight + String.valueOf(numArrivals) + "\n";
            // add the current queue element to the text area
            arrivalsText.setText(arrivalsFlight);
        }
        // initialize string for flight numbers that will be displayed on text area
        String flightTakeOff = "";
        // iterate over the takeOff queue
        for (int numTakeOff : takeOff) {
            // set the string to the current string plus the current queue element
            flightTakeOff = flightTakeOff + String.valueOf(numTakeOff) + "\n";
            // add the current queue element to the text area
            takeoffText.setText(flightTakeOff);
        }

    }

    // method for reading files and 
    public static void fileRead() {
        // initialize file object for arrivals file and takeoff file
        File fileArrivals = new File("arrivals.txt");
        File fileTakeOff = new File("takeOffs.txt");

        try {
            // initialize scanner objects for arrivals file and takeoff file 
            Scanner fileOne = new Scanner(fileArrivals);
            Scanner fileTwo = new Scanner(fileTakeOff);

            // while there are flights in the file
            while (fileOne.hasNextLine()) {
                // set the string to the flight number
                String readLine = fileOne.nextLine();
                // add that integer to the landing queue
                landing.add(Integer.parseInt(readLine));
            }
            // while there are takeoff flights in the file
            while (fileTwo.hasNextLine()) {
                // set the string to the flight number
                String readLine = fileTwo.nextLine();
                // add thatt integer to the takeOff queue
                takeOff.add(Integer.parseInt(readLine));
            }
            // close both file objects after reading from them
            fileOne.close();
            fileTwo.close();
            // catch if the file is not found
        } catch (FileNotFoundException e) {

        }
    }

    // method for updating the queues
    public Queue<Integer> updateQueue(Queue<Integer> inputQueue) {
        // if there were arrivals added to the queues
        if (arrivalsAdded == true) {
            // initialize string for flight numbers that will be displayed in the text area
            String arrivalsFlight = "";
            // iterate over the input queue
            for (int numArrivals : inputQueue) {
                // set the string to the current string plus the current queue element
                arrivalsFlight = arrivalsFlight + String.valueOf(numArrivals) + "\n";
                // add the current queue element to the text area
                arrivalsText.setText(arrivalsFlight);
            }
            // if there were takeoff flights added to the queue
        } else if (takeOffAdded == true) {
            // initialize string for flight numbers that will be displayed in text area
            String flightTakeOff = "";
            // iterate over the input queue
            for (int numTakeOff : inputQueue) {
                // set the string to the current string plus the current queue element
                flightTakeOff = flightTakeOff + String.valueOf(numTakeOff) + "\n";
                // add the current queue element to the text area
                takeoffText.setText(flightTakeOff);
            }
        }
        // if the program is doing the arrivals, and there were no take off or arrivals added
        if (doingArrivals == true && arrivalsAdded == false && takeOffAdded == false) {
            // remove the element from input queue
            inputQueue.remove();
            // initialize string for flight numbers to be displayed in text area
            String arrivalsFlight = "";
            // iterate over input queue
            for (int numArrivals : inputQueue) {
                // set the string to the current string plus the current queue element
                arrivalsFlight = arrivalsFlight + String.valueOf(numArrivals) + "\n";
                // add the current queue element to the text area
                arrivalsText.setText(arrivalsFlight);
            }
            // if the input queue is empty
            if (inputQueue.isEmpty()) {
                // empty the text area
                arrivalsText.setText("");
            }
        }
        // if the program is doing take offs and there were no arrivals or takeoff flights added
        if (doingTakeOffs == true && arrivalsAdded == false && takeOffAdded == false) {
            // remove element from input queue
            inputQueue.remove();
            // initialize string for flight numbers to be displayed in text area
            String flightTakeOff = "";
            // iterate over input queue 
            for (int numTakeOff : inputQueue) {
                // set the string to the current string plus the current queue element
                flightTakeOff = flightTakeOff + String.valueOf(numTakeOff) + "\n";
                // add the current queue element to the text area
                takeoffText.setText(flightTakeOff);
            }
            // if the input queue is empty
            if (inputQueue.isEmpty()) {
                // empty the text area
                takeoffText.setText("");
            }

        }
        // return the input queue
        return inputQueue;
    }

    // class for timer
    private class TimerListener implements ActionListener {

        @Override
        // method when timer is running
        public void actionPerformed(ActionEvent ae) {
            // add one to the counter
            counter = counter + 1;
            // if the landing and take off queue is empty
            if (landing.isEmpty() && takeOff.isEmpty()) {
                // display that the program is waiting for user to enter next flight
                updateLabel.setText("Waiting for next flight");
                // set counter to zero
                counter = 0;
                // if the queues are not empty
            } else {
                // if the take off queue is not empty and there have been two arrivals, and the program is not doing arrivals
                if (!takeOff.isEmpty() && arrivalsCount == 2 && doingArrivals == false) {
                    // set doing take offs to true
                    doingTakeOffs = true;
                    // if the counter is one
                    if (counter == 1) {
                        // display the flight that is next to take off
                        updateLabel.setText("Flight " + takeOff.peek() + " is next to take off ");
                    } else {
                        // display the flight that is next to take off
                        updateLabel.setText("Flight " + takeOff.peek() + " is next to take off " + (4 - counter));
                    }
                    // if the counter is 4
                    if (counter == 4) {
                        // display the flight that departed
                        updateLabel.setText(String.valueOf("Flight " + takeOff.peek()) + " departed");
                        // call the updated queue method with the take off queue as the parameter
                        updateQueue(takeOff);
                        // set counter to zero
                        counter = 0;
                        // set the arrivals count to zero
                        arrivalsCount = 0;
                        // set doing take offs to false
                        doingTakeOffs = false;
                    }
                    // if the take off queue is not empty and the landing queue is empty and the program is not doing the arrivals
                } else if (!takeOff.isEmpty() && landing.isEmpty() && doingArrivals == false) {
                    // set arrivals count to 2
                    arrivalsCount = 2;
                    // set doing take offs to true
                    doingTakeOffs = true;
                    // if the counter is 1
                    if (counter == 1) {
                        // display the flight that is next to take off
                        updateLabel.setText("Flight " + takeOff.peek() + " is next to take off ");
                    } else {
                        // display the flight that is next to take off
                        updateLabel.setText("Flight " + takeOff.peek() + " is next to take off " + (4 - counter));
                    }
                    if (counter == 4) {
                        // display the flight departed
                        updateLabel.setText(String.valueOf("Flight " + takeOff.peek()) + " departed");
                        // call the update queue method with the take off queue as the parameter
                        updateQueue(takeOff);
                        // set counter to zero
                        counter = 0;
                        // set doing take offs to false
                        doingTakeOffs = false;
                    }

                    // if the landing queue is not empty, and there hasnt been two arrivals, and the program is not doing the take offs
                } else if (!landing.isEmpty() && arrivalsCount != 2 && doingTakeOffs == false) {
                    // set doing arrivals to true
                    doingArrivals = true;
                    // if the counter is one
                    if (counter == 1) {
                        // display the flight that is next to land
                        updateLabel.setText(String.valueOf("Flight " + landing.peek()) + " is next to land");
                    } else {
                        // display the flight that is next to land
                        updateLabel.setText(String.valueOf("Flight " + landing.peek()) + " is next to land " + (6 - counter));
                    }
                    // if the count is 6
                    if (counter == 6) {
                        // display the flight that landed
                        updateLabel.setText(String.valueOf("Flight " + landing.peek()) + " landed");
                        // call the update queue method with the landing queue as the parameter
                        updateQueue(landing);
                        // set the counter to zero
                        counter = 0;
                        // add one to the arrivals count
                        arrivalsCount = arrivalsCount + 1;
                        // set doing arrivals to false
                        doingArrivals = false;
                    }

                    // if the take off queue is empty and the program is not doing take offs
                } else if (takeOff.isEmpty() && doingTakeOffs == false) {
                    // set doing arrivals to true
                    doingArrivals = true;
                    // if the counter is one
                    if (counter == 1) {
                        // display the flight that is next to land
                        updateLabel.setText(String.valueOf("Flight " + landing.peek()) + " is next to land");
                    } else {
                        // display the flight that is next to land
                        updateLabel.setText(String.valueOf("Flight " + landing.peek()) + " is next to land " + (6 - counter));
                    }
                    // if the counter is 6
                    if (counter == 6) {
                        // display the flight that landed
                        updateLabel.setText(String.valueOf("Flight " + landing.peek()) + " landed");
                        // call the update queue with the landing queue as the parameter
                        updateQueue(landing);
                        // set counter to zero
                        counter = 0;
                        // set arrivals counter to zero
                        arrivalsCount = 0;
                        // set doing arrivals to false
                        doingArrivals = false;
                    }

                }

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea arrivalsText;
    private javax.swing.JTextField arrivingField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton startBtn;
    private javax.swing.JTextField takeoffField;
    private static javax.swing.JTextArea takeoffText;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
