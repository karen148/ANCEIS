
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.collections.transformation.FilteredList;

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
    private Button eliminarProducto;
    private StackPane productoValores;
    private Scene scene;
    private BorderPane borderPane = new BorderPane();
    private Text ganancias;
    private StackPane layout;

  
    
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
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.setGridLinesVisible(true);
        
        makeRight();
        makeLeft();
        // makeOptions crea y agrupa los botones de Registrar Producto,
        // Eliminar Producto y Registrar Venta
        
        
        borderPane.setCenter(grid);
        makeMenuBar();
        scene = new Scene(borderPane);
        window.setScene(scene);
        window.show();
    }
    public void makeMenuBar(){
        Menu m = new Menu("Inventario"); 
  
        // Items 
        MenuItem m1 = new MenuItem("Cafeteria"); 
        MenuItem m2 = new MenuItem("Afiliados"); 
        MenuItem m3 = new MenuItem("Librería"); 
        
        // agregar el menu a menu items 
        m.getItems().add(m1); 
        m.getItems().add(m2); 
        m.getItems().add(m3); 
        
        // Crear menu bar 
        MenuBar mb = new MenuBar(); 
  
        //  Agregar menu a la brra del menu
        mb.getMenus().add(m); 
  
        // crear VBox 
        VBox vb = new VBox(mb);
        borderPane.setTop(vb);
    }
    public void refresh(){
        grid.getChildren().clear();
        makeRight();
        makeLeft();
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
        GridPane bottomGrid = makeSearchField();
        derecha.getChildren().add(bottomGrid);
        //agrega el VBox al grid pane, en la columna 1 y ocupando 2 filas
        grid.add(derecha,1,0,1,2);
    
    }
    
    /*
     * Retorna el componente de la barra de busqueda.
     */
    public GridPane makeSearchField(){
        FilteredList<Producto> flProduct = new FilteredList(ControllerGUI.getProductos(), p -> true);//Pass the data to a filtered list
        table.setItems(flProduct);//Set the table's items using the filtered list

        TextField searchField = new TextField();
        searchField.setPromptText("Search here!");
        searchField.setOnKeyReleased(keyEvent ->{
            flProduct.setPredicate(p -> p.getNombre().toLowerCase().contains(searchField.getText().toLowerCase().trim()));//filter table by first name
        });
        
        GridPane bottomGrid = new GridPane();
        
        Text buscar = new Text("Buscar");
        barrabusqueda = new HBox(buscar,searchField);
        barrabusqueda.setSpacing(10);
        barrabusqueda.setAlignment(Pos.CENTER_LEFT);
        bottomGrid.add(barrabusqueda,0,0);
        
        Text gananciasLabel = new Text("GANANCIAS");
        ganancias = new Text();
        ganancias.setText(""+Ganancias.TotalGanancia);
        HBox barraGanancias= new HBox(gananciasLabel,ganancias);
        barraGanancias.setSpacing(10);
        barraGanancias.setAlignment(Pos.CENTER_RIGHT);
        bottomGrid.add(barraGanancias, 1, 0);
        grid.setGridLinesVisible(true);
        
        
        return bottomGrid;
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
        
        Text priceLabel = new Text("PRECIO");
        Text priceField = new Text();
        
        Button aceptarVenta = new Button("Registrar");
        aceptarVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Integer.parseInt(cantProduct.getText())< producto.getCantidad()){
                    registrarVenta(producto);
                }
                else{
                    priceField.setText("Debe ingresar una cantidad valida");
                }
            }
        });

        
        // Metodo del campo cantProductque asgina el precio de la compra precio*cantidad
        // a la etiqueda priceField
        cantProduct.setOnKeyReleased(keyEvent ->{
            int c = cantProduct.getText().equals("")  ? 0 : Integer.parseInt(cantProduct.getText());
            priceField.setText(""+producto.getPrecioventa()*c);
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
        
        options.add(priceLabel,0,2);
        options.add(priceField,1,2);
        
        options.add(stack, 0, 3, 2, 1); 

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
        layout = new StackPane();
        layout.getChildren().add(state);
        ganancias.setText(""+Ganancias.TotalGanancia);

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
        layout = new StackPane();
        layout.getChildren().add(state);
        grid.add(layout,0,1,1,2);   
    }
    
    /*
     * Metodo para eliminar el producto que esté seleccionado en la tabla
     */
    public void eliminarProducto(Producto producto){
        ControllerGUI.eliminarPro(producto.getNombre());
        refresh();
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
        state = new Text();
        options = new VBox();
        registrarVenta = new Button("Registrar venta");
        registrarVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Producto producto = table.getSelectionModel().getSelectedItem();
                if(producto != null){
                    refresh();
                    definirVenta(producto);
                }else{
                }
               
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
        eliminarProducto = new Button("Eliminar producto");
        eliminarProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Producto producto = table.getSelectionModel().getSelectedItem();
                if(producto!=null){
                    eliminarProducto(producto);
                }else{
                }
                
            }
        });
        options.getChildren().add(eliminarProducto);
        
        options.setSpacing(30);
        options.setAlignment(Pos.CENTER);
        options.setMinWidth(100);
        options.setMinHeight(200);
        return options;
    }
    
    public TableView<Producto> makeTable(){
    
        //Name column
        TableColumn<Producto, String> nameColumn = new TableColumn<>("Producto");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Price column
        TableColumn<Producto, String> priceColumn = new TableColumn<>("Precio Venta");
        priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("precioventa"));

        //Quantity column
        TableColumn<Producto, String> quantityColumn = new TableColumn<>("Cantidad");
        quantityColumn.setMinWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
                
        table = new TableView<>();
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        
        table.setItems(ControllerGUI.getProductos());
        return table;
    }

}