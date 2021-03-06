import javax.swing.ImageIcon;

public class StaffResult extends javax.swing.JPanel {
    
    private final Database.Staff result;
    
    public StaffResult(Database.Staff result) {
        initComponents();
        // Fill out every field with the proper data
        this.result = result;
        nameLabel.setText(result.name);
        descLabel.setText(result.department);
        officeLabel.setText(result.officeLoc);
        imageIcon.setIcon(new ImageIcon(result.icon.getScaledInstance(54, 72, 0)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        innerPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        imageIcon = new javax.swing.JLabel();
        officeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(300, 102));
        setMinimumSize(new java.awt.Dimension(300, 102));
        setPreferredSize(new java.awt.Dimension(300, 102));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameLabel.setText("Name");

        descLabel.setText("Description");

        officeLabel.setText("Office");

        javax.swing.GroupLayout innerPanelLayout = new javax.swing.GroupLayout(innerPanel);
        innerPanel.setLayout(innerPanelLayout);
        innerPanelLayout.setHorizontalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(descLabel)
                    .addComponent(officeLabel))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        innerPanelLayout.setVerticalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(innerPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(officeLabel)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(innerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(innerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Display the StaffDetails for the clicked staff member
        Main.DirFrame.displayPanel.removeAll();
        Main.DirFrame.displayPanel.add(new StaffDetails(result));
        // Refresh the panel
        Main.DirFrame.displayPanel.revalidate();
        Main.DirFrame.displayPanel.repaint();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel imageIcon;
    private javax.swing.JPanel innerPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel officeLabel;
    // End of variables declaration//GEN-END:variables
}