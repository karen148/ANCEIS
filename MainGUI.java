import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
public class MainGUI {
	
	private static final String VERSION = "ANCEIS v1.0";
	private JFrame frame;
    private JLabel statusLabel;
    private JPanel south;
    private JButton btn;
    private JLabel etiqueta;
    private JLabel ganancias;
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();

	public MainGUI() {

		makeFrame();

	}
	
	public static void main(String[] args) {
		
		MainGUI main = new MainGUI();

	}
	
	private void makeFrame(){
        frame = new JFrame("Cafeteria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeMenuBar(frame);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(10,10));
        
        // Crea panel de botones y agrega lo dos botones, Registrar Producto y registrar venta
        south = new JPanel();
        south.setLayout(new GridLayout(2,3,30,20));
        
        //Crea el boton registrar venta
        btn = new JButton("Registrar Venta");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 addProduct();
            }
        });
        south.add(btn);
        
        
        //Crea el boton "Registrar Producto" el cual llama al metodo addProduct
        btn = new JButton("Registrar Producto");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 addProduct();
            }
        });
        south.add(btn);
        
        btn = new JButton("Eliminar Producto");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	deleteProduct();
            }
        });
        south.add(btn);
        
        etiqueta = new JLabel("GANANCIAS HASTA EL MOMENTO:");
        south.add(etiqueta);
        ganancias = new JLabel("GANANCIAS");
        south.add(ganancias);
        contentPane.add(south, BorderLayout.CENTER);
        
        
        /* Llama el metodo showProductos que retorna el scrollPane con la tabla
        *  la cual contiene los productos de cafeteria.
        */
        JScrollPane scrollPane = showProducts();        
        contentPane.add(scrollPane, BorderLayout.NORTH);
        
        
        /*  Etiqueta del fondo con el nombre del programa y la versión
         */
        statusLabel = new JLabel(VERSION);
        contentPane.add(statusLabel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	private JScrollPane showProducts() {
		String[] columns = {"Producto",
                "Cantidad Disponible",
                "Precio venta/unidad"};
        model.setColumnIdentifiers(columns);
        
		Object[][] data = {
			    {"Papas", "30",
			      new Integer(1000)}
			};
		
		table = new JTable();
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		table.setGridColor(Color.black);
		Font font = new Font("",0 ,18);
		table.setFont(font);
        table.setRowHeight(30);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        //scrollPane.setBounds(0, 0, 880, 200);
		return scrollPane;
	}
	
	
	/*
	 *  Sale una ventana emergente y agrega un producto a cafeteria 
	 */
	private void addProduct() {
		/*JFrame addproduct = new JFrame();
		addproduct.setVisible(true);
		addproduct.setSize(250,250);
		addproduct.setLocationRelativeTo(null);*/
		String[] row = new String[4];
   	 	row[0] = "0";
        row[1] = "0";
        row[2] = "0";
        row[3] = "0";
        
        // add row to the model
        model.addRow(row);
	}
	
	
	private void deleteProduct() {
		// i = index de la columna seleccionada
        int i = table.getSelectedRow();
        if(i >= 0){
            // remover una fila de la tabla
            model.removeRow(i);
        }
        else{
            System.out.println("Delete Error");
        }
	}
	

	
	
	
	
	
	
	
	
	
	private void makeMenuBar(JFrame frame){
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();


        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // create the File menu
        menu = new JMenu("Inventario");
        menubar.add(menu);
        
        item = new JMenuItem("Cafeteria");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {}
                           });
        menu.add(item);

        item = new JMenuItem("Afiliaciones");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {}
                           });
        menu.add(item);
        menu.addSeparator();
        
        item = new JMenuItem("Libreria");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {}
                           });
        menu.add(item);

        // create the Ayuda menu
        menu = new JMenu("Ayuda");
        menubar.add(menu);
        
        item = new JMenuItem("Acerca de ANCEIS...");
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {  }
                           });
        menu.add(item);

    }
}




