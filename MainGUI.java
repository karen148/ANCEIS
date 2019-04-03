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

public class MainGUI extends Application {

    private Stage window;
    private TableView<Producto> table;
    private VBox options;
    private GridPane grid;
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
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(500));
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(200));
        
        //El metodo makeTable se encarga de hacer la tabla para mostrar los productos
        table = makeTable();
        grid.add(table,1,0);
        grid.add(new Label("Aqui va la barra de busqueda o arriba"),1,1);
        
        // makeOptions crea y agrupa los botones de Registrar Producto,
        // Eliminar Producto y Registrar Venta
        options = makeOptions();
        grid.add(options,0,0);
        

        
        
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
    
    /*
     * Crea los campos para solicitar los valores del producto, para luego crearlo.
     */
    public void askProductValues(){
        // Etiqueta para el nombre
        Text nameLabel = new Text("Nombre"); 
        // Campo de texto para el nombre
        TextField nameField = new TextField();  
        
        // Etiqueta para la cantidad
        Text cantLabel = new Text("Cantidad"); 
        // Campo de texto para la cantidad
        TextField cantField = new TextField();
        cantField.textProperty().addListener(new ChangeListener<String>() {
            
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        cantField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
        }); 
        
        // Etiqueta para el precio de venta
        Text preciovLabel = new Text("Precio venta"); 
        // Campo de texto para el precio de venta
        TextField preciovField = new TextField();
        cantField.textProperty().addListener(new ChangeListener<String>() {
            
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
        TextField preciocField = new TextField();
        cantField.textProperty().addListener(new ChangeListener<String>() {
            
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        preciocField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
        }); 
        //Agrupa los campos en una Grid;
        GridPane options = new GridPane();
        options.setHgap(10);
        options.setVgap(10);
        
        options.add(nameLabel, 0, 0); 
        options.add(nameField, 1, 0);
        
        options.add(cantLabel, 0, 1); 
        options.add(cantField, 1, 1);
        
        options.add(preciovLabel, 0, 2); 
        options.add(preciovField, 1, 2);
        
        options.add(preciocLabel, 0, 3); 
        options.add(preciocField, 1, 3);
        
        options.setPrefSize(300, 300);
        grid.add(options,0,1);
    }
    
    public VBox makeOptions(){
        options = new VBox();
        Button button1 = new Button("Registrar venta");
        options.getChildren().add(button1);
        Button button2= new Button("Registrar producto");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                askProductValues();
            }
        });
        options.getChildren().add(button2);
        
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
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("producto"));

        //Price column
        TableColumn<Producto, Double> priceColumn = new TableColumn<>("Precio");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("precioventa"));

        //Quantity column
        TableColumn<Producto, String> quantityColumn = new TableColumn<>("Cantidad");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        table = new TableView<>();
        table.setItems(ControllerGUI.getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        return table;
    }

}