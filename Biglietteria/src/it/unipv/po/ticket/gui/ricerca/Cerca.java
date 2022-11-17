package it.unipv.po.ticket.gui.ricerca;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cerca extends JFrame {


	private JFrame frame;
	private DBread leggi = new DBread();
	private Ricerca ricerca = new Ricerca();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cerca window = new Cerca();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Cerca() throws Exception {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 320, 530);
		frame.getContentPane().setLayout(null);
		
		JPanel bar = new JPanel();
		bar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bar.setLayout(null);
		bar.setBounds(314, 10, 207, 473);
		frame.getContentPane().add(bar);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(0, 56, 207, 63);
		bar.add(btnNewButton);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(0, 117, 207, 63);
		bar.add(btnCerca);
		
		JButton btnAreaPersonale = new JButton("Area personale");
		btnAreaPersonale.setBounds(0, 178, 207, 63);
		bar.add(btnAreaPersonale);
		
		JButton btnContatti = new JButton("Contatti");
		btnContatti.setBounds(0, 240, 207, 63);
		bar.add(btnContatti);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 22, 207, 13);
		bar.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 63, 284, 420);
		frame.getContentPane().add(panel);
		
		JToggleButton tglBiglietto = new JToggleButton("Biglietto");
		tglBiglietto.setSelected(true);
		tglBiglietto.setBounds(10, 21, 127, 21);
		panel.add(tglBiglietto);
		
		JToggleButton tglAbbonamento = new JToggleButton("Abbonamento");
		tglAbbonamento.setBounds(147, 21, 127, 21);
		panel.add(tglAbbonamento);
		
		JComboBox comboBoxPartenza = new JComboBox(leggi.elencoFermate());
		comboBoxPartenza.setMaximumRowCount(10);
		comboBoxPartenza.setBackground(Color.WHITE);
		comboBoxPartenza.setBounds(147, 90, 103, 30);
		panel.add(comboBoxPartenza);
		
		JComboBox comboBoxArrivo = new JComboBox(leggi.elencoFermate());
		comboBoxArrivo.setMaximumRowCount(10);
		comboBoxArrivo.setBackground(Color.WHITE);
		comboBoxArrivo.setBounds(147, 157, 103, 30);
		panel.add(comboBoxArrivo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 225, 264, 2);
		panel.add(separator);
		
		JButton cercaBtn = new JButton("Cerca");
		cercaBtn.setBounds(98, 382, 85, 21);
		panel.add(cercaBtn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 370, 264, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 52, 264, 3);
		panel.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Fermata di partenza");
		lblNewLabel.setBounds(10, 99, 148, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fermata di arrivo");
		lblNewLabel_1.setBounds(10, 166, 148, 13);
		panel.add(lblNewLabel_1);
		
		JSlider orarioSlider = new JSlider();
		orarioSlider.setValue(24);
		orarioSlider.setMaximum(47);
		orarioSlider.setBounds(40, 318, 200, 22);
		panel.add(orarioSlider);
		
		JLabel orarioPartenzatxt = new JLabel("12:00");
		orarioPartenzatxt.setBounds(28, 295, 45, 13);
		panel.add(orarioPartenzatxt);
		
		JLabel orarioMaxtxt = new JLabel("23:59");
		orarioMaxtxt.setHorizontalAlignment(SwingConstants.CENTER);
		orarioMaxtxt.setBounds(205, 295, 45, 13);
		panel.add(orarioMaxtxt);
		
		JLabel orariotxt = new JLabel("A che ora vuoi partire?");
		orariotxt.setBounds(28, 250, 172, 13);
		panel.add(orariotxt);
		
		Image img = new ImageIcon("image\\menu.png").getImage();
		Image newImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(262, 23, 30, 30);
		btnNewButton_1.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Image img;
				Image newImage;
				
				if(frame.getBounds().width != 545) {
				
					frame.setBounds(100, 100, 545, 530);
					img = new ImageIcon("image\\close.png").getImage();
					newImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
					btnNewButton_1.setIcon(new ImageIcon(newImage));
				}else {
					frame.setBounds(100, 100, 320, 530);
					img = new ImageIcon("image\\menu.png").getImage();
					newImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
					btnNewButton_1.setIcon(new ImageIcon(newImage));
				}
			}
		});
		
		//Azioni
		
		tglBiglietto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tglBiglietto.isSelected() == true) {
					tglAbbonamento.setSelected(false);
					separator.setVisible(true);
					orarioMaxtxt.setVisible(true);
					orarioPartenzatxt.setVisible(true);
					orarioSlider.setVisible(true);
					orariotxt.setVisible(true);
				}
				else {
					tglAbbonamento.setSelected(true);
					separator.setVisible(false);
					orarioMaxtxt.setVisible(false);
					orarioPartenzatxt.setVisible(false);
					orarioSlider.setVisible(false);
					orariotxt.setVisible(false);
				}
				
			}
		});
				
		tglAbbonamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglAbbonamento.isSelected() == true) {
					tglBiglietto.setSelected(false);
					separator.setVisible(false);
					orarioMaxtxt.setVisible(false);
					orarioPartenzatxt.setVisible(false);
					orarioSlider.setVisible(false);
					orariotxt.setVisible(false);
				}
				else {
					tglBiglietto.setSelected(true);
					separator.setVisible(true);
					orarioMaxtxt.setVisible(true);
					orarioPartenzatxt.setVisible(true);
					orarioSlider.setVisible(true);
					orariotxt.setVisible(true);
				}
			}
		});
		
		cercaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxPartenza.getSelectedItem() != "" && comboBoxArrivo.getSelectedItem() != "") {
					try {
						Cerca2.main(ricerca.cerca(comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString(), LocalTime.parse(orarioPartenzatxt.getText())));
						frame.setVisible(false);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else JOptionPane.showMessageDialog(null, "Fermate non selezionate","Search error",JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
		orarioSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int a = orarioSlider.getValue()/2;
				int b = (orarioSlider.getValue()%2)*30;	

				String str = LocalTime.of(a,b).toString();
				
				orarioPartenzatxt.setText(str);
			}
		});
		
	}
}
