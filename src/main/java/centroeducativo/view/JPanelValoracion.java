package centroeducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import centroeducativo.entities.Materia;
import centroeducativo.entities.Profesor;
import javax.swing.JScrollPane;

public class JPanelValoracion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Integer> jcbNota;
	

	/**
	 * Create the panel.
	 */
	public JPanelValoracion() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 220, 254));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 50, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel jlblMateria = new JLabel("Materia:");
		jlblMateria.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_jlblMateria = new GridBagConstraints();
		gbc_jlblMateria.anchor = GridBagConstraints.EAST;
		gbc_jlblMateria.insets = new Insets(10, 10, 10, 5);
		gbc_jlblMateria.gridx = 0;
		gbc_jlblMateria.gridy = 0;
		panel.add(jlblMateria, gbc_jlblMateria);
		
		jcbMateria = new JComboBox<Materia>();
		jcbMateria.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(10, 0, 10, 10);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(5, 10, 10, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox<Profesor>();
		jcbProfesor.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(5, 0, 10, 10);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(5, 10, 10, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox<Integer>();
		// Bucle que agrega al JCombo Notas enteros del 1-10.
		for (int i = 0; i <= 10; i++) {
			jcbNota.addItem(i);
		}
		// Muestro, por defecto, el primer item.
		jcbNota.setSelectedIndex(0);
		jcbNota.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(5, 0, 10, 10);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton jbtnActualizar = new JButton("Botón Actualizar Alumnado");
		jbtnActualizar.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_jbtnActualizar = new GridBagConstraints();
		gbc_jbtnActualizar.insets = new Insets(10, 0, 10, 10);
		gbc_jbtnActualizar.anchor = GridBagConstraints.EAST;
		gbc_jbtnActualizar.gridx = 1;
		gbc_jbtnActualizar.gridy = 3;
		panel.add(jbtnActualizar, gbc_jbtnActualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblAlumnadoNoSeleccionado = new JLabel("Alumnado No Seleccionado");
		lblAlumnadoNoSeleccionado.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblAlumnadoNoSeleccionado = new GridBagConstraints();
		gbc_lblAlumnadoNoSeleccionado.insets = new Insets(10, 0, 5, 5);
		gbc_lblAlumnadoNoSeleccionado.gridx = 0;
		gbc_lblAlumnadoNoSeleccionado.gridy = 0;
		panel_1.add(lblAlumnadoNoSeleccionado, gbc_lblAlumnadoNoSeleccionado);
		
		JLabel lblAlumnadoNoSeleccionado_1 = new JLabel("Alumnado Seleccionado");
		lblAlumnadoNoSeleccionado_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblAlumnadoNoSeleccionado_1 = new GridBagConstraints();
		gbc_lblAlumnadoNoSeleccionado_1.insets = new Insets(10, 0, 5, 0);
		gbc_lblAlumnadoNoSeleccionado_1.gridx = 2;
		gbc_lblAlumnadoNoSeleccionado_1.gridy = 0;
		panel_1.add(lblAlumnadoNoSeleccionado_1, gbc_lblAlumnadoNoSeleccionado_1);
		
		JScrollPane jscpNoSelect = new JScrollPane();
		GridBagConstraints gbc_jscpNoSelect = new GridBagConstraints();
		gbc_jscpNoSelect.insets = new Insets(0, 10, 10, 10);
		gbc_jscpNoSelect.fill = GridBagConstraints.BOTH;
		gbc_jscpNoSelect.gridx = 0;
		gbc_jscpNoSelect.gridy = 1;
		panel_1.add(jscpNoSelect, gbc_jscpNoSelect);
		
		JList jlNoSelect = new JList();
		jlNoSelect.setFont(new Font("Arial", Font.PLAIN, 12));
		jscpNoSelect.setViewportView(jlNoSelect);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 10, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton jbtnAllNoSelect = new JButton("<<");
		jbtnAllNoSelect.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_jbtnAllNoSelect = new GridBagConstraints();
		gbc_jbtnAllNoSelect.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnAllNoSelect.gridx = 0;
		gbc_jbtnAllNoSelect.gridy = 0;
		panel_2.add(jbtnAllNoSelect, gbc_jbtnAllNoSelect);
		
		JButton jbtnNoSelect = new JButton("<");
		jbtnNoSelect.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_jbtnNoSelect = new GridBagConstraints();
		gbc_jbtnNoSelect.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnNoSelect.gridx = 0;
		gbc_jbtnNoSelect.gridy = 1;
		panel_2.add(jbtnNoSelect, gbc_jbtnNoSelect);
		
		JButton jbtnSelect = new JButton(">");
		jbtnSelect.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_jbtnSelect = new GridBagConstraints();
		gbc_jbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnSelect.gridx = 0;
		gbc_jbtnSelect.gridy = 2;
		panel_2.add(jbtnSelect, gbc_jbtnSelect);
		
		JButton jbtnAllSelect = new JButton(">>");
		jbtnAllSelect.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_jbtnAllSelect = new GridBagConstraints();
		gbc_jbtnAllSelect.gridx = 0;
		gbc_jbtnAllSelect.gridy = 3;
		panel_2.add(jbtnAllSelect, gbc_jbtnAllSelect);
		
		JScrollPane jscpSelect = new JScrollPane();
		GridBagConstraints gbc_jscpSelect = new GridBagConstraints();
		gbc_jscpSelect.insets = new Insets(0, 10, 10, 10);
		gbc_jscpSelect.fill = GridBagConstraints.BOTH;
		gbc_jscpSelect.gridx = 2;
		gbc_jscpSelect.gridy = 1;
		panel_1.add(jscpSelect, gbc_jscpSelect);
		
		JList jlSelect = new JList();
		jlSelect.setFont(new Font("Arial", Font.PLAIN, 12));
		jscpSelect.setViewportView(jlSelect);
		
		JButton jbtnGuardar = new JButton("Guardar las Notas de Todos los Alumnos Seleccionados");
		jbtnGuardar.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_jbtnGuardar = new GridBagConstraints();
		gbc_jbtnGuardar.insets = new Insets(50, 0, 20, 0);
		gbc_jbtnGuardar.gridx = 0;
		gbc_jbtnGuardar.gridy = 2;
		add(jbtnGuardar, gbc_jbtnGuardar);

	}

}
