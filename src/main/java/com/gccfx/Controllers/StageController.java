package com.gccfx.Controllers;

import com.gccfx.Error.FieledIsEmptyException;
import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import com.gccfx.Model.*;
import com.gccfx.dataBase.data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class StageController implements Initializable {

    public static int indexCat = 0;
    public static int indexParam = 0;
    @FXML
    private Spinner<Integer> Me_e;

    @FXML
    private Spinner<Integer> Mm_e;

    @FXML
    private Spinner<Integer> Mm_p;

    @FXML
    private Spinner<Integer> Mp_e;

    @FXML
    private Spinner<Integer> Mp_m;

    @FXML
    private Spinner<Integer> Mp_p;

    @FXML
    private Spinner<Integer> Pe_e;

    @FXML
    private Spinner<Integer> Pm_e;

    @FXML
    private Spinner<Integer> Pm_m;

    @FXML
    private Spinner<Integer> Pm_p;

    @FXML
    private Spinner<Integer> Pp_e;

    @FXML
    private Spinner<Integer> Pp_m;
    @FXML
    private Spinner<Integer> Mm_m;

    @FXML
    private Spinner<Integer> Pp_p;
    @FXML
    private Label e_e;
    @FXML
    private Label m_e;

    @FXML
    private Label m_m;

    @FXML
    private Label m_p;
    @FXML
    private Label p_e;
    @FXML
    private Label p_m;

    @FXML
    private Label p_p;
    @FXML
    private final TableView<catIntervalle> tableCategorie = new TableView<>();
    @FXML
    private GridPane Cats;
    @FXML
    private TableColumn<PlanAction, String> pourcentage;

    @FXML
    private TableColumn<PlanAction, String> probabilite;
    @FXML
    private TableView<PlanAction> orderAction;
    @FXML
    private TableColumn<PlanAction, String> x;
    @FXML
    private GridPane catGridTotal;

    @FXML
    private TableView<TableIntervalle> orderActionTable = new TableView<>();
    LinkedList<Categorie> categories = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLebalT0();
        initialiseAllSniper();
        categories = data.categories;
        int col = 1;
        int row = 0;
        int col1 = 0;
        int row1 = 0;
        try {
            for (Categorie categorie : categories) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                VBox vBox = FXMLLoader.load(Main.class.getResource("views/categorie.fxml"));
                CategorieStage categorieStage = fxmlLoader.getController();
                //set padings of the VBox to 10px
                vBox.setPadding(new Insets(10, 10, 10, 10));
                //set the spacing between the children of the VBox to 10px
                vBox.setSpacing(10);
                indexCat++;

                if (col == 2) {
                    col = 0;
                    row++;
                }
                //spacing to vbox
                vBox.setSpacing(20);
                Cats.add(vBox, col++, row);
                GridPane.setMargin(vBox, new Insets(10));
                //set with of the column 50%
                Label label = new Label(categorie.getName());
                //set label bold
                label.setStyle("-fx-font-weight: bold");
                label.setPadding(new Insets(3, 3, 3, 3));

                label.setStyle("-fx-font-weight: bold");
                TextField textField = new TextField();
                //se the textfield under the label
                HBox hBox = new HBox();
                //hbox element center
                hBox.setAlignment(javafx.geometry.Pos.CENTER);
                hBox.setSpacing(20);
                //black border to the hbox
                hBox.setStyle("-fx-border-color: black");
                textField.setId("moyenParam");
                hBox.getChildren().addAll(label, textField);
                //add the vBox to the total grid

                if (col1 == 3) {
                    col1 = 0;
                    row1++;
                }
                catGridTotal.add(hBox, col1++, row1);
                GridPane.setMargin(hBox, new Insets(10));

            }
            indexParam = 0;

            fieldTheTableCatetegorie();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLebalT0() {
        e_e.setText("0");
        m_e.setText("0");
        m_m.setText("0");
        m_p.setText("0");
        p_e.setText("0");
        p_m.setText("0");
        p_p.setText("0");
    }

    public void initialiseAllSniper() {
        //value between 1 and 10
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Me_e.setValueFactory(valueFactory);
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Mm_e.setValueFactory(valueFactory1);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Mm_m.setValueFactory(valueFactory2);
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Mm_p.setValueFactory(valueFactory3);
        SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Mp_e.setValueFactory(valueFactory4);
        SpinnerValueFactory<Integer> valueFactory5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Mp_m.setValueFactory(valueFactory5);
        SpinnerValueFactory<Integer> valueFactory6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Mp_p.setValueFactory(valueFactory6);
        SpinnerValueFactory<Integer> valueFactory7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pe_e.setValueFactory(valueFactory7);
        SpinnerValueFactory<Integer> valueFactory8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pm_e.setValueFactory(valueFactory8);
        SpinnerValueFactory<Integer> valueFactory9 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pm_m.setValueFactory(valueFactory9);
        SpinnerValueFactory<Integer> valueFactory10 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pm_p.setValueFactory(valueFactory10);
        SpinnerValueFactory<Integer> valueFactory11 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pp_e.setValueFactory(valueFactory11);
        SpinnerValueFactory<Integer> valueFactory12 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pp_m.setValueFactory(valueFactory12);
        SpinnerValueFactory<Integer> valueFactory13 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        Pp_p.setValueFactory(valueFactory13);
    }


    public void initialiseValueMpe(Map<String, Double> map) {
        //get index of the max in the map
        String index = String.valueOf(0);
        double max = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");


        //set the value of the max
        if (index.equals("M")) {
            m_m.setText(String.valueOf(df.format(map.get("M") / 100)));
            m_e.setText(String.valueOf(df.format(map.get("E") / 100)));
            m_p.setText(String.valueOf(df.format(map.get("P") / 100)));
        } else if (index.equals("E")) {
            e_e.setText(String.valueOf(df.format(map.get("E") / 100)));
            m_e.setText(String.valueOf(df.format(map.get("M") / 100)));
            p_e.setText(String.valueOf(df.format(map.get("P") / 100)));
        } else if (index.equals("P")) {
            p_p.setText(String.valueOf(df.format(map.get("P") / 100)));
            p_e.setText(String.valueOf(df.format(map.get("E") / 100)));
            p_m.setText(String.valueOf(df.format(map.get("M") / 100)));
        }
        //display double value with 2 decimal


    }

    public void getTheValueOfTheSpinner() {
        Map<String, Integer> map= new HashMap<>();
        map.put("M->M", (Integer) Mm_m.getValue());
        map.put("M->E", (Integer) Mm_e.getValue());
        map.put("M->P", (Integer) Mm_p.getValue());
        map.put("E->E", (Integer) Me_e.getValue());
        map.put("P->P", (Integer) Mp_p.getValue());
        map.put("P->E", (Integer) Mp_e.getValue());
        map.put("P->M", (Integer) Mp_m.getValue());

        

        data.mapM = map;
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("M->M", (Integer) Pm_m.getValue());
        map1.put("M->E", (Integer) Pm_e.getValue());
        map1.put("M->P", (Integer) Pm_p.getValue());
        map1.put("E->E", (Integer) Pe_e.getValue());
        map1.put("P->P", (Integer) Pp_p.getValue());
        map1.put("P->E", (Integer) Pp_e.getValue());
        map1.put("E->M", (Integer) Pp_m.getValue());
        data.mapP = map1;


        //get the value of the spinner
    }

    void fieldTheTableCatetegorie() {
        LinkedList<Interval> intervals = data.intervalles;
        TableColumn<TableIntervalle, String> nameCategorie = new TableColumn<TableIntervalle, String>("name categorie");
        nameCategorie.setCellValueFactory(
                new PropertyValueFactory<>("nameCategorie")
        );
        TableColumn<TableIntervalle, ComboBox>[] mpe = new TableColumn[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            mpe[i] = new TableColumn<>(intervals.get(i).getMin() + "-" + intervals.get(i).getMax());
            mpe[i].setCellValueFactory(
                    new PropertyValueFactory<>("inter" + (i + 1))
            );
        }
        orderActionTable.getColumns().add(nameCategorie);
        orderActionTable.getColumns().addAll(mpe);

        ObservableList<TableIntervalle> list = getTable();
        orderActionTable.setItems(list);
    }


    public Map<String, Double> getTabalAction() {
        //get all element of the table categorie
        ObservableList<TableIntervalle> list = orderActionTable.getItems();
        int i = 0;
        String[] tab = new String[categories.size()];
        for (TableIntervalle tableIntervalle : list) {
            System.out.println(tableIntervalle.getNameCategorie());
            for (int j = 0; j < data.nbIntervalles; j++) {
                if (data.intervalles.get(j).getBorneInf() <= categories.get(i).getMoyenne() && data.intervalles.get(j).getBorneSup() > categories.get(i).getMoyenne()) {
                    tab[i] = tableIntervalle.getInter(j + 1);
                }
            }
            i++;
        }
        Map<String, Double> map = new HashMap<>();
        ObservableList<String> list1 = FXCollections.observableArrayList("M", "P", "E");
        map.put("M", 0.0);
        map.put("P", 0.0);
        map.put("E", 0.0);

        int k = 0;
        char tabMpe[][] = new char[data.categories.size()][3];
        for (String s : tab) {
            String[] t = s.split("/");
            for (int j = 0; j < t.length; j++) {
                tabMpe[k][j] = t[j].charAt(0);
                map.put(t[j], map.get(t[j]) + data.niveau.getNiveau(j + 1));
            }
            k++;
        }
        map.put("M", map.get("M") / (double) data.categories.size());
        map.put("P", map.get("P") / (double) data.categories.size());
        map.put("E", map.get("E") / (double) data.categories.size());
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        data.mapMPEValues = map;
        return map;

    }


    @FXML
    void enregister(ActionEvent event) {
        //switch to scen stageFinal
        try {
            getTheValueOfTheSpinner();
            Stage s = AddCategorieController.switchToNext(event, "views/FinalStage.fxml", "Stage Final");
            //open the scene in the center of the screen
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            s.setX((primScreenBounds.getWidth() - s.getWidth()) / 2);
            s.setY((primScreenBounds.getHeight() - s.getHeight()) / 2);
            s.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ObservableList<TableIntervalle> getTable() {
        ObservableList<TableIntervalle> list = FXCollections.observableArrayList();
        ObservableList<String> listMpe = FXCollections.observableArrayList(
                "M/P/E", "M/E/P",
                "P/M/E", "P/E/M", "E/M/P",
                "E/P/M"
        );
        for (Categorie categorie : categories) {
            list.add(new TableIntervalle(categorie.getName(), listMpe));
        }
        //afficher la list
        for (TableIntervalle tableIntervalle : list) {
            System.out.println(tableIntervalle);
        }
        return list;
    }

    @FXML
    void generate(ActionEvent event) {
        data.afficher();
        getTabalAction();
        Map<String, Double> map = getTabalAction();
        afficherTablePlanAction(map);
        initialiseValueMpe(map);
        getTheValueOfTheSpinner();
    }
    // add the name of the categorie to the table

    void afficherTablePlanAction(Map<String, Double> tabalAction) {
        //format display dicimal 2
        DecimalFormat df = new DecimalFormat("#.##");
        data.machine = tabalAction.get("M");
        data.pair = tabalAction.get("P");
        data.ensignant = tabalAction.get("E");
        probabilite.setCellValueFactory(new PropertyValueFactory<PlanAction, String>("probabilite"));
        pourcentage.setCellValueFactory(new PropertyValueFactory<PlanAction, String>("purcentage"));
        x.setCellValueFactory(new PropertyValueFactory<PlanAction, String>("x"));

        ObservableList<PlanAction> tableIntervalles = FXCollections.observableArrayList(
                new PlanAction("Machine", df.format(tabalAction.get("M")) + "%", df.format(tabalAction.get("M") / 100) + ""),
                new PlanAction("Enseignat", df.format(tabalAction.get("E")) + "%", df.format(tabalAction.get("E") / 100) + ""),
                new PlanAction("Pair", df.format(tabalAction.get("P")) + "%", df.format(tabalAction.get("P") / 100) + ""));
        orderAction.setItems(tableIntervalles);
        //sort the table by pourcentage order by desc
        orderAction.getSortOrder().add(probabilite);


    }

    public void reset(ActionEvent actionEvent) {
        //reset the table
        ObservableList<TableIntervalle> list = getTable();
        orderActionTable.setItems(list);
        //reset the textfield
        for (int i = 0; i < Cats.getChildren().size(); i++) {
            VBox vBox = (VBox) Cats.getChildren().get(i);
            for (int j = 0; j < vBox.getChildren().size(); j++) {
                HBox hBox = (HBox) vBox.getChildren().get(j);
                for (int k = 0; k < hBox.getChildren().size(); k++) {
                    if (hBox.getChildren().get(k) instanceof TextField) {
                        TextField textField = (TextField) hBox.getChildren().get(k);
                        textField.setText("");
                    }
                }
            }
        }
    }

    public void CatculerCat(ActionEvent actionEvent) throws FieledIsEmptyException {
        //boucle to get categorie name by i
        for (int i = 1, k = 0; i < Cats.getChildren().size() && k < categories.size(); i++, k++) {
            Label namecat = (Label) Cats.getChildren().get(i).lookup("#nameCat");
            GridPane gridPane = (GridPane) Cats.getChildren().get(i).lookup("#params");
            if (gridPane != null) {
                for (int j = 0; j < gridPane.getChildren().size(); j++) {
                    Label nameParam = (Label) gridPane.getChildren().get(j).lookup("#nameParam");
                    TextField valueParam = (TextField) gridPane.getChildren().get(j).lookup("#valueParam");
                    try {
                        if (valueParam.getText().isEmpty()) {
                            throw new FieledIsEmptyException("le champ de categorie " + namecat.getText() + " et parametre " + nameParam.getText() + " est vide");
                        } else {
                            this.categories.get(k).getParametres().get(j).setValeur(Double.parseDouble(valueParam.getText()));
                        }
                    } catch (FieledIsEmptyException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println(gridPane);
            }
        }
        for (int i = 0; i < catGridTotal.getChildren().size(); i++) {
            TextField textField = (TextField) catGridTotal.getChildren().get(i).lookup("#moyenParam");
            categories.get(i).CalculMoyenne();
            textField.setText("" + categories.get(i).getMoyenne());
            textField.setEditable(false);
        }
        data.afficher();
    }

}
