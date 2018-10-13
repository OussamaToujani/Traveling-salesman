package traveling.sales.man;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUI {
	Population pop;
	int poop;
	int taille=50;
	double rate=0.015;
	int gener=100;
	int di=0;
	int df=0;
	

	private JFrame frmA;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		City city = new City(80, 200);
		city.name="city";
        ListOfCitiesToVisit.addCity(city);
        City city2 = new City(200, 200);
        city2.name="city2";
        ListOfCitiesToVisit.addCity(city2);
        City city3 = new City(90, 180);
        city3.name="city3";
        ListOfCitiesToVisit.addCity(city3);
        City city4 = new City(180, 180);
        city4.name="city4";
        ListOfCitiesToVisit.addCity(city4);
        City city5 = new City(60, 160);
        city5.name="city5";
        ListOfCitiesToVisit.addCity(city5);
        City city6 = new City(135, 160);
        city6.name="city6";
        ListOfCitiesToVisit.addCity(city6);
        City city7 = new City(210, 160);
        city7.name="city7";
        ListOfCitiesToVisit.addCity(city7);
        City city8 = new City(170, 140);
        city8.name="city8";
        ListOfCitiesToVisit.addCity(city8);
        City city9 = new City(40, 120);
        city9.name="city9";
        ListOfCitiesToVisit.addCity(city9);
        City city10 = new City(130, 120);
        city10.name="city10";
        ListOfCitiesToVisit.addCity(city10);
        City city11 = new City(210, 100);
        city11.name="city11";
        ListOfCitiesToVisit.addCity(city11);
        City city12 = new City(60, 80);
        city12.name="city12";
        ListOfCitiesToVisit.addCity(city12);
        City city13 = new City(120, 80);
        city13.name="city13";
        ListOfCitiesToVisit.addCity(city13);
        City city14 = new City(220, 60);
        city14.name="city14";
        ListOfCitiesToVisit.addCity(city14);
        City city15 = new City(20, 40);
        city15.name="city15";
        ListOfCitiesToVisit.addCity(city15);
        City city16 = new City(100, 40);
        city16.name="city16";
        ListOfCitiesToVisit.addCity(city16);
        City city17 = new City(240, 40);
        city17.name="city17";
        ListOfCitiesToVisit.addCity(city17);
        City city18 = new City(20, 20);
        city18.name="city18";
        ListOfCitiesToVisit.addCity(city18);
        City city19 = new City(60, 20);
        city19.name="city19";
        ListOfCitiesToVisit.addCity(city19);
        City city20 = new City(180, 20);
        city20.name="city20";
        ListOfCitiesToVisit.addCity(city20);
        
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmA = new JFrame();
		frmA.setTitle("Traveling sales man problem solution using a genetic algorithm");
		frmA.getContentPane().setForeground(Color.BLACK);
		frmA.setBounds(100, 100, 780, 410);
		frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmA.getContentPane().setLayout(null);
		
		CityMap panel = new CityMap(null);
		
		textField = new JTextField();
		textField.setBounds(569, 83, 86, 20);
		frmA.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(569, 39, 86, 20);
		frmA.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 39, 325, 255);
		frmA.getContentPane().add(panel);
		
		JLabel lblGenerations = new JLabel("Generations:");
		lblGenerations.setBounds(450, 42, 126, 14);
		frmA.getContentPane().add(lblGenerations);
		
		JLabel lblTailleDePopulation = new JLabel("Population size :");
		lblTailleDePopulation.setBounds(450, 86, 185, 14);
		frmA.getContentPane().add(lblTailleDePopulation);
		
		JLabel lblMeilleurChemin = new JLabel("Map of the cities to visit:");
		lblMeilleurChemin.setBounds(39, 14, 306, 14);
		frmA.getContentPane().add(lblMeilleurChemin);
		
		JLabel lblTauxDeMutation = new JLabel("mutation rate:"+Double.toString(rate));
		lblTauxDeMutation.setBounds(450, 128, 185, 14);
		frmA.getContentPane().add(lblTauxDeMutation);
		
		JLabel lblLongeurDeLa = new JLabel("Length of the best path from the 1st generation :" + Integer.toString(di));
		lblLongeurDeLa.setBounds(370, 196, 400, 39);
		frmA.getContentPane().add(lblLongeurDeLa);
		
		JLabel label = new JLabel("Length of the best path from the last generation :"+Integer.toString(df));
		label.setBounds(370, 246, 400, 27);
		frmA.getContentPane().add(label);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener((ActionEvent arg0) -> {
                    // Initialiser population
                    poop = Integer.parseInt(textField.getText());
                    pop = new Population(poop, true);
                    
                    di=pop.getBestPath().getDistance();
                    panel.pop=pop;
                    panel.repaint();
                    lblMeilleurChemin.setText("Best path of the 1st generation:");
                    lblLongeurDeLa.setText("Length of the best path from the last generation :"+Integer.toString(di));
                });
		btnStart.setBounds(386, 317, 120, 23);
		frmA.getContentPane().add(btnStart);
		
		JButton btnEvolution = new JButton("Evolution!");
		btnEvolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				poop = Integer.parseInt(textField_1.getText());
		        pop = EvolutionOperations.evolverPopulation(pop);
		        for (int i = 0; i < gener; i++) {
		            pop = EvolutionOperations.evolverPopulation(pop);
		        }
		        panel.pop=pop;
		        panel.repaint();
		        lblMeilleurChemin.setText("the best path from the final generation:");
		        
		        
		        df = pop.getBestPath().getDistance();
		        label.setText("Length of the best path of the last generation :"+Integer.toString(df));
		        
			}
		});
		btnEvolution.setBounds(546, 317, 120, 23);
		frmA.getContentPane().add(btnEvolution);
		
		JLabel lblOussamaToujani = new JLabel("By Oussama Toujani");
		lblOussamaToujani.setBounds(49, 321, 149, 14);
		frmA.getContentPane().add(lblOussamaToujani);
		
	}
}
