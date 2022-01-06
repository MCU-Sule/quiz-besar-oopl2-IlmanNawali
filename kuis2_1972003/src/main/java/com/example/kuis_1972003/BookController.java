/**
 * 1972003 Ilman Nawali
 */
package com.example.kuis_1972003;

import com.example.DAO.BookDAO;
import com.example.Model.BukuEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    public TableView<BukuEntity> tableView;
    public TableColumn<BukuEntity, String> col1;
    public TableColumn<BukuEntity, String> col2;
    public TableColumn<BukuEntity, String> col3;
    public TableColumn<BukuEntity, String> col4;
    public TableColumn<BukuEntity, String> col5;
    public TableColumn<BukuEntity, String> col6;
    public TextField txt1;
    public TextField txt2;
    public TextField txt4;
    public TextField txt3;
    public TextField txt5;
    public TextField txt6;
    private ObservableList<BukuEntity> bukus;
    private Main controller;
    public void setController2 (Main controller){
        tableView.setItems(controller.getBukus());
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookDAO bookDAO = new BookDAO();
        bukus = (ObservableList<BukuEntity>) bookDAO.showData();
        tableView.setItems(bukus);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJudul())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPenerbit())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTahunTerbit())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPengarang())));
        col6.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJenisBuku())));
    }

    public void saveButton(ActionEvent actionEvent) {
        BukuEntity buku =new BukuEntity();
        buku.setId(Integer.valueOf(txt1.getText()));
        buku.setJudul(txt2.getText());
        buku.setPenerbit(txt3.getText());
        buku.setTahunTerbit(txt4.getText());
        buku.setPengarang(txt5.getText());
        buku.setJenisBuku(txt6.getText());
        BookDAO bookDAO = new BookDAO();
        bookDAO.addData(buku);
        controller.getBukus().clear();
        controller.getBukus().addAll(bookDAO.showData());
        tableView.refresh();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
    }
}
