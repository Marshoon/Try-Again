import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class GUI {
	public static Player Hero;

	private static Entity[] tempE;
	private static JTextPane history;
	private static int index;
	JFrame frmWelcome;
	static JFrame charCreate;
	public static JFrame game;
	private JTextField txtName;
	private final Action action = new Done();
	private final Action action1 = new SwingAction();
	private final Action tom = new action_1();
	private static JTextField textField;
	private static JTextField txtConsole;
	private static JProgressBar progressBar;
	private static JSlider slider;
	private static KeyEvent entr;
	public static JComboBox<Item> Weapons;
	public static JComboBox<Entity> Enemies;
	private JComboBox<Item> Food;

	public GUI() {
		Splash();
	}

	private void Splash() {

		frmWelcome = new JFrame();
		frmWelcome.setTitle("Zoraka!");
		frmWelcome.setBounds(100, 100, 450, 300);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);

		frmWelcome.setResizable(false);

		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setAction(action1);
		btnNewButton_1.setBounds(166, 124, 117, 29);
		frmWelcome.getContentPane().add(btnNewButton_1);

	}

	private class SwingAction extends AbstractAction {

		public SwingAction() {
			putValue(NAME, "Play");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			charCreate();
		}
	}

	private void charCreate() {

		frmWelcome.setVisible(false);

		charCreate = new JFrame();
		charCreate.setTitle("Welcome!");
		charCreate.setBounds(100, 100, 450, 300);
		charCreate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		charCreate.getContentPane().setLayout(null);

		charCreate.setVisible(true);

		charCreate.setResizable(false);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setText("NAME");
		txtName.setBounds(130, 58, 190, 28);
		charCreate.getContentPane().add(txtName);
		txtName.setColumns(10);

		String[] classes = { "Knight", "Rogue", "Mage" };

		JButton btnNewButton = new JButton("Done");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(167, 182, 117, 29);
		charCreate.getContentPane().add(btnNewButton);

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMaximum(2);
		slider.setBounds(122, 95, 200, 30);
		charCreate.getContentPane().add(slider);

		Label label = new Label("Knight");
		label.setAlignment(Label.CENTER);
		label.setBounds(105, 118, 50, 25);
		charCreate.getContentPane().add(label);

		Label label_1 = new Label("Rogue");
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(197, 118, 50, 25);
		charCreate.getContentPane().add(label_1);

		Label label_2 = new Label("Mage");
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(288, 118, 50, 25);
		charCreate.getContentPane().add(label_2);
	}

	private class Done extends AbstractAction {

		public Done() {
			putValue(NAME, "Done");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String name = txtName.getText();
			System.out.println(name);
			String race = null;

			int num = slider.getValue();

			if (num == 0) {
				race = "knight";
			} else if (num == 1) {
				race = "rogue";
			} else if (num == 2) {
				race = "mage";
			}

			updateChar(name, race);

		}
	}

	public Player updateChar(String name, String race) {
		Hero = new Player(name, 20, 20, 10, 3, race);
		for (int i = 0; i < Hero.getInventory().length; i++) {
			if ((int) (Math.random() * 100) >= 50) {
				Hero.inventory[i] = Generator.nextMeleeWeapon((int) (Math
						.random() * 4));
			} else {
				Hero.inventory[i] = Generator.nextFood();
			}
		}
		Hero.setCurrentC(0);
		Hero.setCurrentR(0);
		play();
		return Hero;
	}

	private void play() {
		charCreate.setVisible(false);

		game = new JFrame();
		game.setTitle("Zoraka");
		game.setBounds(100, 100, 450, 300);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getContentPane().setLayout(null);

		game.setVisible(true);
		game.setResizable(false);

		history = new JTextPane();
		history.setEditable(false);
		history.setBounds(95, 43, 184, 232);
		game.getContentPane().add(history);

		JScrollPane scroll = new JScrollPane(history);
		scroll.setBounds(260, 6, 184, 232);
		game.getContentPane().add(scroll);

		textField = new JTextField();
		textField.setBounds(260, 245, 180, 28);
		game.getContentPane().add(textField);
		textField.setColumns(10);

		progressBar = new JProgressBar();
		progressBar.setValue(Hero.getHealth());
		progressBar.setToolTipText(Hero.getHealth() + " / " + Hero.h);
		progressBar.setMaximum(20);
		progressBar.setBounds(6, 6, 146, 20);
		game.getContentPane().add(progressBar);

		JButton enter = new JButton("ENTER");
		enter.setAction(tom);
		enter.setBounds(179, 245, 76, 28);
		game.getContentPane().add(enter);

		Weapons = new JComboBox<Item>();
		Weapons.setToolTipText("Name - Dmg - Durability");
		Weapons.setBounds(6, 145, 214, 20);
		game.getContentPane().add(Weapons);
		Item[] tempW = Hero.getInventory();
		for (int i = 0; i < tempW.length; i++) {
			if (tempW[i] != null
					&& tempW[i].getType().equalsIgnoreCase("weapon")) {
				Weapons.addItem(tempW[i]);
			}
		}
		Enemies = new JComboBox<Entity>();
		Enemies.setToolTipText("Name - Dmg - Health");
		Enemies.setBounds(6, 214, 214, 20);
		game.getContentPane().add(Enemies);
		Entity[] tempE = new Entity[Engine.map[Player.getCurrentR()][Player
				.getCurrentC()].getEntities().length];
		tempE = Engine.map[Player.getCurrentR()][Player.getCurrentC()]
				.getEntities();
		for (int i = 0; i < tempE.length; i++) {
			if (tempE[i] != null) {
				Enemies.addItem(tempE[i]);
			}
		}
		Food = new JComboBox<Item>();
		Food.setToolTipText("Name - Heal Value");
		Food.setBounds(6, 180, 100, 20);
		game.getContentPane().add(Food);
		Item[] tempF = Hero.getInventory();
		for (int i = 0; i < tempF.length; i++) {
			if (tempF[i] != null && tempF[i].getType().equalsIgnoreCase("food")) {
				Food.addItem(tempF[i]);
			}
		}
	}

	private class action_1 extends AbstractAction {

		public action_1() {
			putValue(NAME, "Done");
			putValue(SHORT_DESCRIPTION, "Sends command to console");
		}

		public void actionPerformed(ActionEvent e) {
			update();
		}
	}

	private static void update() {
		if (textField.getText().equals("")) {
			System.out.println("Please put in a command");
		} else {

			String curr = history.getText();
			String result = (textField.getText());
			history.setText(curr + result + "\n");

			String response = Engine.recog(result);
			tempE = Engine.map[Player.getCurrentR()][Player.getCurrentC()].getEntities();
			
			Hero.setDamage(Hero.bs + (((Weapon) (Weapons.getSelectedItem())).getDamage()));
			
			if (result.equalsIgnoreCase("attack")) {
				((Entity) Enemies.getSelectedItem()).setHealth(((Entity) Enemies.getSelectedItem()).getHealth() - Hero.getDamage());
				if (((tempE[Enemies.getSelectedIndex()].getHealth() <= 0))) {
					tempE[Enemies.getSelectedIndex()] = null;
				}
			}

			curr = history.getText();

			history.setText(curr + response + "\n");

			textField.setText(null);
		}

	}
}
