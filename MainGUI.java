
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.collections.transformation.FilteredList;
import javafx.scene.layout.StackPane;

public class MainGUI extends Application {

    private Stage window;
    private TableView<Producto> table;
    private VBox options;
    private GridPane grid;
    private HBox barrabusqueda;
    private TextField nameProduct;
    private TextField cantProduct;
    private TextField preciovField;
    private TextField preciocField;
    private Text state = new Text();
    private Button registrarVenta;
    private Button registrarProducto;
    private StackPane productoValores;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window = primaryStage;
        window.setTitle("Cafeteria - ANCEIS");
        // Creamos una grilla donde van a ir nuestros componentes,
        // la tabla, los botones, la barra de busqueda y un campo que se muestra
        // con las opciones de registrar y eliminar producto.
        grid = new GridPane();
        
        GridPane.setMargin(grid,new Insets(20,20,20,20));
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(500));
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.setGridLinesVisible(true);
        
        makeRight();
        makeLeft();
        // makeOptions crea y agrupa los botones de Registrar Producto,
        // Eliminar Producto y Registrar Venta
        
        

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
    public void refresh(){
        grid.getChildren().clear();
        makeRight();
        makeLeft();
        StackPane layout = new StackPane();
        layout.getChildren().add(state);
        grid.add(layout,0,1,1,2);
    }
    
    public void makeLeft(){
        options = makeOptions();
        grid.add(options,0,0);
    }
    
    public void makeRight(){
         // VBox para la tabla ya la barra de busqueda
        VBox derecha = new VBox();
        //El metodo makeTable se encarga de hacer la tabla para mostrar los productos
        table = makeTable();
        derecha.getChildren().add(table);
        //crea barra de busqueda y lo agrega al VBOX
        makeSearchField();
        derecha.getChildren().add(barrabusqueda);
        //agrega el VBox al grid pane, en la columna 1 y ocupando 2 filas
        grid.add(derecha,1,0,1,2);
    
    }
    
    public void definirVenta(Producto producto){

        // Borra el contenido del label state
        state.setText("");
        // Etiqueta para el nombre
        Text nombre = new Text(producto.getNombre());
        //Etiqueta para la cantidad
        Text cantLabel = new Text("Cantidad"); 
        // Campo de texto para la cantidad
        cantProduct = new TextField();
        cantProduct.textProperty().addListener(new ChangeListener<String>() {
            
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        cantProduct.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
        }); 
        
        Button aceptarVenta = new Button("Registrar");
        aceptarVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registrarVenta(producto);
            }
        });
        
        StackPane stack = new StackPane();
        stack.getChildren().add(aceptarVenta);
        
        StackPane stack2 = new StackPane();
        stack2.getChildren().add(nombre);
        
        GridPane options = new GridPane();
        options.setHgap(10);
        options.setVgap(10);
        
        options.add(stack2, 0, 0, 2, 1); 
       
        options.add(cantLabel, 0, 1); 
        options.add(cantProduct, 1, 1); 
        
        options.add(stack, 0, 2, 2, 1); 

        options.setPrefSize(300, 300);
        GridPane.setMargin(options, new Insets(0,50,0,40));
        grid.add(options,0,1);
        
        
    }

    public void registrarVenta(Producto producto){

        String nombre = producto.getNombre();
        int cantidad = Integer.parseInt(cantProduct.getText());
        ControllerGUI.registrarVen(nombre,cantidad);
        grid.getChildren().clear();
        refresh();
        state.setText("La venta se realizó correctamente");
        StackPane layout = new StackPane();
        layout.getChildren().add(state);
        grid.add(layout,0,1,1,2);
    }
    
    /*
     * Obtiene los valores de los campos para registrar el producto
     * y llama al meotodo de registrarProducto de el controlador
     * Luego actualiza el scene
     */
    
    public void registrarProducto(){
        String nombre = nameProduct.getText();
        int preciocompra = Integer.parseInt(preciocField.getText());
        int precioventa = Integer.parseInt(preciovField.getText());
        int cantidad = Integer.parseInt(cantProduct.getText());
        ControllerGUI.registrarPro(nombre, preciocompra, precioventa, cantidad);
        grid.getChildren().clear();
        refresh();
        state.setText("El producto se agregó correctamente");
        StackPane layout = new StackPane();
        layout.getChildren().add(state);
        grid.add(layout,0,1,1,2);   
    }

    
    /*
     * Retorna el componente de la barra de busqueda.
     */
    public void makeSearchField(){
        FilteredList<Producto> flProduct = new FilteredList(ControllerGUI.getProductos(), p -> true);//Pass the data to a filtered list
        table.setItems(flProduct);//Set the table's items using the filtered list

        TextField searchField = new TextField();
        searchField.setPromptText("Search here!");
        searchField.setOnKeyReleased(keyEvent ->{
            flProduct.setPredicate(p -> p.getNombre().toLowerCase().contains(searchField.getText().toLowerCase().trim()));//filter table by first name
        });
        
        Text buscar = new Text("Buscar");
        barrabusqueda = new HBox(buscar,searchField);
        barrabusqueda.setSpacing(10);
        barrabusqueda.setAlignment(Pos.CENTER);
    }
    /*
     * Crea los campos para solicitar los valores del producto, para luego crearlo.
     */
    public void askProductValues(){
        // Borra el contenido del label state
        state.setText("");
        // Etiqueta para el nombre
        Text nameLabel = new Text("Nombre"); 
        // Campo de texto para el nombre
        nameProduct = new TextField();  
        
        // Etiqueta para la cantidad
        Text cantLabel = new Text("Cantidad"); 
        // Campo de texto para la cantidad
        // con un metodo para que solo acepte numeros
        cantProduct = new TextField();
        cantProduct.textProperty().addListener(new ChangeListener<String>() {
            
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        cantProduct.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
        }); 
        
        // Etiqueta para el precio de venta
        Text preciovLabel = new Text("Precio venta"); 
        // Campo de texto para el precio de venta
        preciovField = new TextField();
        preciovField.textProperty().addListener(new ChangeListener<String>() {
            
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        preciovField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
        }); 
         // Etiqueta para el precio de compra
        Text preciocLabel = new Text("Precio compra"); 
        // Campo de texto para el precio de compra
        preciocField = new TextField();
        preciocField.textProperty().addListener(new ChangeListener<String>() {
            
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        preciocField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
        }); 
        
        Button aceptarProducto = new Button("Registrar");
        aceptarProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registrarProducto();
            }
        });
        productoValores = new StackPane();
        productoValores.getChildren().add(aceptarProducto);
        //Agrupa los campos en una Grid;
        GridPane options = new GridPane();
        options.setHgap(10);
        options.setVgap(10);
        
        options.add(nameLabel, 0, 0); 
        options.add(nameProduct, 1, 0);
        
        options.add(cantLabel, 0, 1); 
        options.add(cantProduct, 1, 1);
        
        options.add(preciovLabel, 0, 2); 
        options.add(preciovField, 1, 2);
        
        options.add(preciocLabel, 0, 3); 
        options.add(preciocField, 1, 3);
        
        options.add(productoValores, 0, 4, 2,1); 
        
        
        options.setPrefSize(300, 300);
        GridPane.setMargin(options, new Insets(0,0,0,40));
        grid.add(options,0,1);
        
    }
    
    public VBox makeOptions(){
        options = new VBox();
        registrarVenta = new Button("Registrar venta");
        registrarVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Producto producto = table.getSelectionModel().getSelectedItem();
                refresh();
                definirVenta(producto);
            }
        });
        options.getChildren().add(registrarVenta);
        
        registrarProducto= new Button("Registrar producto");
        registrarProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refresh();
                askProductValues();
            }
        });
        options.getChildren().add(registrarProducto);
        
        options.setSpacing(50);
        options.setAlignment(Pos.CENTER);
        options.setMinWidth(100);
        options.setMinHeight(200);
        return options;
    }
    
    public TableView<Producto> makeTable(){
    
        //Name column
        TableColumn<Producto, String> nameColumn = new TableColumn<>("Producto");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Price column
        TableColumn<Producto, String> priceColumn = new TableColumn<>("Precio Venta");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("precioventa"));

        //Quantity column
        TableColumn<Producto, String> quantityColumn = new TableColumn<>("Cantidad");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
                
        table = new TableView<>();
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        
        table.setItems(ControllerGUI.getProductos());
        return table;
    }

}