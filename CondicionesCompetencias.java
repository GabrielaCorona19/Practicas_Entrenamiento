package condicionescompetencias;
import javax.swing.JOptionPane;

public class CondicionesCompetencias extends javax.swing.JFrame {
    private Hilo t1,t2,t3,t4;
    private RCompartido rc;
    private Cerradura cerradura = new Cerradura();
    private alternancia alt = new alternancia();
    private dijkstra d = new dijkstra();
    private mutex mut = new mutex(true);

    public CondicionesCompetencias() {
        initComponents();
        rc = new RCompartido();
        t1 = new Hilo(area1, rc);
        t1.setName("Perrito1");
        t2 = new Hilo(area2, rc);
        t2.setName("Perrito2");
        t3 = new Hilo(area3, rc);
        t3.setName("Perrito3");
        t4 = new Hilo(area4, rc);
        t4.setName("Perrito4");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        area2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        area3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        area4 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Condiciones = new javax.swing.JRadioButtonMenuItem();
        interrupciones = new javax.swing.JRadioButtonMenuItem();
        alternancia = new javax.swing.JRadioButtonMenuItem();
        vCerradura = new javax.swing.JRadioButtonMenuItem();
        dijkstra = new javax.swing.JRadioButtonMenuItem();
        mutex = new javax.swing.JRadioButtonMenuItem();
        mutexArt = new javax.swing.JRadioButtonMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Kill  ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Stop");

        area1.setColumns(20);
        area1.setRows(5);
        jScrollPane1.setViewportView(area1);

        area2.setColumns(20);
        area2.setRows(5);
        jScrollPane2.setViewportView(area2);

        area3.setColumns(20);
        area3.setRows(5);
        jScrollPane3.setViewportView(area3);

        area4.setColumns(20);
        area4.setRows(5);
        jScrollPane4.setViewportView(area4);

        jLabel1.setText("Plato 1");

        jLabel2.setText("Plato 2");

        jLabel3.setText("Plato 3");

        jLabel4.setText("Plato 4");

        jMenu1.setText("File");

        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Algoritmos");

        Condiciones.setText("Condiciones Competencia");
        Condiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CondicionesActionPerformed(evt);
            }
        });
        jMenu5.add(Condiciones);

        interrupciones.setText("Desactivacion de Interrupciones");
        interrupciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interrupcionesActionPerformed(evt);
            }
        });
        jMenu5.add(interrupciones);

        alternancia.setText("Dekker(alternancia estricta)");
        alternancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternanciaActionPerformed(evt);
            }
        });
        jMenu5.add(alternancia);

        vCerradura.setText("Petterson(VCerradura)");
        vCerradura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCerraduraActionPerformed(evt);
            }
        });
        jMenu5.add(vCerradura);

        dijkstra.setText("Dijkstra(Paper)");
        dijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dijkstraActionPerformed(evt);
            }
        });
        jMenu5.add(dijkstra);

        mutex.setText("Mutex API");
        mutex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutexActionPerformed(evt);
            }
        });
        jMenu5.add(mutex);

        mutexArt.setText("Mutex");
        mutexArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutexArtActionPerformed(evt);
            }
        });
        jMenu5.add(mutexArt);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addGap(138, 138, 138)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(108, 108, 108)
                .addComponent(jLabel4)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void reiniciarHilos(){
        t1.setSalir();
        t2.setSalir();
        t3.setSalir();
        t4.setSalir();       
        
        area1.setText("");
        area2.setText("");
        area3.setText("");
        area4.setText("");
        
        t1 = new Hilo(area1, rc);
        t1.setName("Perrito1");
        t2 = new Hilo(area2, rc);
        t2.setName("Perrito2");
        t3 = new Hilo(area3, rc);
        t3.setName("Perrito3");
        t4 = new Hilo(area4, rc);
        t4.setName("Perrito4");
        
    }
    private void entrenamiento(int ent){
        t1.setEntrenamiento(ent);
        t2.setEntrenamiento(ent);
        t3.setEntrenamiento(ent);
        t4.setEntrenamiento(ent);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(Condiciones.isSelected()){
            entrenamiento(0);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }else{
            if(interrupciones.isSelected()){
                rc.iniciarInterrupcion();
                entrenamiento(1);
                t1.setTiempo(550);
                t2.setTiempo(600);
                t3.setTiempo(650);
                t4.setTiempo(700);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
            }else{
                if(vCerradura.isSelected()){
                    entrenamiento(2);
                    t1.start();
                    t2.start();
                    t3.start();
                    t4.start();
                }else{
                    if(mutex.isSelected()){
                        entrenamiento(3);
                        t1.start();
                        t2.start();
                        t3.start();
                        t4.start();
                    }else{
                        if(alternancia.isSelected()){
                            entrenamiento(4);
                            
                            t1.start();
                            t2.start();
                            t3.start();
                            t4.start();
                            
                        }else{
                            if(dijkstra.isSelected()){
                                entrenamiento(5);                          
                                t1.start();
                                t2.start();
                                t3.start();
                                t4.start();
                            }else{
                                if(mutexArt.isSelected()){
                                    entrenamiento(6);
                                    t1.setTiempo(550);
                                    t2.setTiempo(600);
                                    t3.setTiempo(650);
                                    t4.setTiempo(700);
                                    t1.start();
                                    t2.start();
                                    t3.start();
                                    t4.start();
                                }else{
                                    JOptionPane.showMessageDialog(rootPane, "Selecciona un algoritmo");
                                }
                            }
                            
                        }
                         
                    }
                   
                }
                
            }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         t1.matar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dijkstraActionPerformed
        reiniciarHilos();
        d.reiniciar();
        
       Condiciones.setSelected(false);
       vCerradura.setSelected(false);
       mutex.setSelected(false);
       interrupciones.setSelected(false);
       alternancia.setSelected(false);
       mutexArt.setSelected(false);

       t1.dijkstra(d);
       t2.dijkstra(d);
       t3.dijkstra(d);
       t4.dijkstra(d);

    }//GEN-LAST:event_dijkstraActionPerformed

    private void mutexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutexActionPerformed
        reiniciarHilos();
        interrupciones.setSelected(false);
        Condiciones.setSelected(false);
        vCerradura.setSelected(false);
        alternancia.setSelected(false);
        dijkstra.setSelected(false);
        mutexArt.setSelected(false);
       
    }//GEN-LAST:event_mutexActionPerformed

    private void CondicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CondicionesActionPerformed
       reiniciarHilos();
       interrupciones.setSelected(false);
       vCerradura.setSelected(false);
       mutex.setSelected(false);
       alternancia.setSelected(false);
       dijkstra.setSelected(false);
       mutexArt.setSelected(false);
    }//GEN-LAST:event_CondicionesActionPerformed

    private void interrupcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interrupcionesActionPerformed
       reiniciarHilos();
       Condiciones.setSelected(false);
       vCerradura.setSelected(false);
       mutex.setSelected(false);
       alternancia.setSelected(false);
       dijkstra.setSelected(false);
       mutexArt.setSelected(false);
    }//GEN-LAST:event_interrupcionesActionPerformed

    private void alternanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternanciaActionPerformed
        reiniciarHilos();
        alt.reiniciar();
        
       Condiciones.setSelected(false);
       vCerradura.setSelected(false);
       mutex.setSelected(false);
       interrupciones.setSelected(false);
       dijkstra.setSelected(false);
       mutexArt.setSelected(false);
       
        t1.alternancia(alt);
        t2.alternancia(alt);
        t3.alternancia(alt);
        t4.alternancia(alt);
       
        
    }//GEN-LAST:event_alternanciaActionPerformed

    private void vCerraduraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCerraduraActionPerformed
        reiniciarHilos();
        
        interrupciones.setSelected(false);
        Condiciones.setSelected(false);
        mutex.setSelected(false);
        alternancia.setSelected(false);
        dijkstra.setSelected(false);
        mutexArt.setSelected(false);
        
        cerradura.reiniciar();
        t1.setCerradura(cerradura);
        t2.setCerradura(cerradura);
        t3.setCerradura(cerradura);
        t4.setCerradura(cerradura);
    }//GEN-LAST:event_vCerraduraActionPerformed

    private void mutexArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutexArtActionPerformed
        reiniciarHilos();
        
        vCerradura.setSelected(false);
        interrupciones.setSelected(false);
        Condiciones.setSelected(false);
        mutex.setSelected(false);
        alternancia.setSelected(false);
        dijkstra.setSelected(false);
        
        t1.setMutex(mut);
        t2.setMutex(mut);
        t3.setMutex(mut);
        t4.setMutex(mut);
    }//GEN-LAST:event_mutexArtActionPerformed

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
            java.util.logging.Logger.getLogger(CondicionesCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CondicionesCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CondicionesCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CondicionesCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CondicionesCompetencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem Condiciones;
    private javax.swing.JRadioButtonMenuItem alternancia;
    private javax.swing.JTextArea area1;
    private javax.swing.JTextArea area2;
    private javax.swing.JTextArea area3;
    private javax.swing.JTextArea area4;
    private javax.swing.JRadioButtonMenuItem dijkstra;
    private javax.swing.JRadioButtonMenuItem interrupciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButtonMenuItem mutex;
    private javax.swing.JRadioButtonMenuItem mutexArt;
    private javax.swing.JRadioButtonMenuItem vCerradura;
    // End of variables declaration//GEN-END:variables
    
  
}
