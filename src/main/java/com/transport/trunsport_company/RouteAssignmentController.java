package com.transport.trunsport_company;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class RouteAssignmentController {
    private ObservableList<DriverData> drivers = FXCollections.observableArrayList();

    private TableView<DriverData> tableView = new TableView<>();

    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField middleNameField = new TextField();
    private TextField licenseNumberField = new TextField();
    private TextField searchField = new TextField();

    public VBox getView() {
        firstNameField.setPromptText("Имя");
        lastNameField.setPromptText("Фамилия");
        middleNameField.setPromptText("Отчество");
        licenseNumberField.setPromptText("№ ВУ");

        HBox inputBox = new HBox(10, firstNameField, lastNameField, middleNameField, licenseNumberField);
        inputBox.setPadding(new Insets(10));

        Button addButton = new Button("Добавить");
        Button deleteButton = new Button("Удалить");
        Button searchButton = new Button("Найти по имени");

        addButton.setOnAction(e -> addDriver());
        deleteButton.setOnAction(e -> deleteDriver());
        searchButton.setOnAction(e -> searchDriver());

        HBox buttonBox = new HBox(10, addButton, deleteButton, searchField, searchButton);
        buttonBox.setPadding(new Insets(10));

        TableColumn<DriverData, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<DriverData, String> firstNameCol = new TableColumn<>("Имя");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<DriverData, String> lastNameCol = new TableColumn<>("Фамилия");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<DriverData, String> middleNameCol = new TableColumn<>("Отчество");
        middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        TableColumn<DriverData, String> licenseCol = new TableColumn<>("№ ВУ");
        licenseCol.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));

        tableView.getColumns().addAll(idCol, firstNameCol, lastNameCol, middleNameCol, licenseCol);
        tableView.setItems(drivers);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox layout = new VBox(10, inputBox, buttonBox, tableView);
        layout.setPadding(new Insets(10));

        return layout;
    }

    private void addDriver() {
        String first = firstNameField.getText();
        String last = lastNameField.getText();
        String middle = middleNameField.getText();
        String license = licenseNumberField.getText();

        if (!first.isEmpty() && !last.isEmpty() && !license.isEmpty()) {
            DriverData driver = new DriverData(first, last, middle, license);
            drivers.add(driver);

            firstNameField.clear();
            lastNameField.clear();
            middleNameField.clear();
            licenseNumberField.clear();
        } else {
            showAlert("Ошибка", "Имя, фамилия и номер ВУ обязательны.");
        }
    }

    private void deleteDriver() {
        DriverData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            drivers.remove(selected);
        } else {
            showAlert("Ошибка", "Выберите водителя для удаления.");
        }
    }
    private void searchDriver() {
        String query = searchField.getText().trim().toLowerCase();
        if (!query.isEmpty()) {
            ObservableList<DriverData> result = FXCollections.observableArrayList();
            for (DriverData d : drivers) {
                if (d.getFirstName().toLowerCase().contains(query)) {
                    result.add(d);
                }
            }
            tableView.setItems(result);
        } else {
            tableView.setItems(drivers); // сброс
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}