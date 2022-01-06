/**
 * 1972003 Ilman Nawali
 */

package com.example.kuis_1972003;

import com.example.DAO.BookDAO;
import com.example.DAO.MemberDAO;
import com.example.DAO.PeminjamanDAO;
import com.example.Model.AnggotaEntity;
import com.example.Model.BukuEntity;
import com.example.Model.PeminjamanEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Main implements Initializable {
    public BorderPane exit;


    Stage stage;
    public TableView<PeminjamanEntity> tableView;
    public TableColumn<PeminjamanEntity, String> col1;
    public TableColumn<PeminjamanEntity, String> col2;
    public TableColumn<PeminjamanEntity, String> col3;
    public TableColumn<PeminjamanEntity, String> col4;
    public TableColumn<PeminjamanEntity, String> col5;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnReset;
    public TextField txt1;
    public DatePicker date1;
    public DatePicker date2;
    public TextField txt3;
    public TextField txt5;
    public TextField txt6;
    public ComboBox<AnggotaEntity> com1;
    public ComboBox<BukuEntity> com2;
    private ObservableList<BukuEntity> bukus;
    private ObservableList<AnggotaEntity> anggotas;
    private ObservableList<PeminjamanEntity> peminjamans;


    public ObservableList<AnggotaEntity> getAnggotas(){
        return anggotas;
    }

    public ObservableList<BukuEntity> getBukus(){
        return bukus;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MemberDAO memberDAO = new MemberDAO();
        BookDAO bookDAO = new BookDAO();
        PeminjamanDAO peminjamanDAO = new PeminjamanDAO();
        anggotas = (ObservableList<AnggotaEntity>) memberDAO.showData();
        bukus = (ObservableList<BukuEntity>) bookDAO.showData();
        peminjamans = (ObservableList<PeminjamanEntity>) peminjamanDAO.showData();
        tableView.setItems(peminjamans);
        com1.setItems(anggotas);
        com2.setItems(bukus);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getAnggotaByAnggotaId().getNama())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getBukuByBukuId().getJudul())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPinjam())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPengembalian())));
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnReset.setDisable(false);
    }

    public void buttonSave(ActionEvent actionEvent) {
        PeminjamanEntity peminjaman =new PeminjamanEntity();
        peminjaman.setId(Integer.valueOf(txt1.getText()));
        peminjaman.setTanggalPinjam(Date.valueOf(date1.getValue()));
        peminjaman.setTanggalPengembalian(Date.valueOf(date2.getValue()));
        peminjaman.setAnggotaByAnggotaId(com1.getValue());
        peminjaman.setBukuByBukuId(com2.getValue());
        PeminjamanDAO peminjamanDAO = new PeminjamanDAO();
        peminjamanDAO.addData(peminjaman);
        peminjamans.clear();
        peminjamans.addAll(peminjamanDAO.showData());
        tableView.refresh();
        txt1.setText("");
        date1.setValue(null);
        date2.setValue(null);
        com1.setValue(null);
        com2.setValue(null);
    }

    public void buttonUpdate(ActionEvent actionEvent) {
        PeminjamanEntity selected;
        selected = tableView.getSelectionModel().getSelectedItem();
        selected.setTanggalPengembalian(Date.valueOf(date1.getValue()));
        selected.setTanggalPengembalian(Date.valueOf(date2.getValue()));
        selected.setAnggotaByAnggotaId(com1.getValue());
        selected.setBukuByBukuId(com2.getValue());
        PeminjamanDAO peminjamanDAO = new PeminjamanDAO();
        int result = peminjamanDAO.updateData(selected);
        if (result != 0){
            System.out.println("Update Berhasil");
        }
        peminjamans.clear();
        peminjamans.addAll(peminjamanDAO.showData());
        tableView.refresh();
        btnSave.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        txt1.setDisable(false);
        txt1.clear();
        date1.setValue(null);
        date2.setValue(null);
        com1.setValue(null);
        com2.setValue(null);
    }

    public void btnDelete(ActionEvent actionEvent) {
        PeminjamanEntity selected;
        selected = (PeminjamanEntity) tableView.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        PeminjamanDAO peminjamanDAO = new PeminjamanDAO();
        int result = peminjamanDAO.delData(selected);
        if (result != 0){
            System.out.println("Delete Berhasil");
        }
        peminjamans.clear();
        peminjamans.addAll(peminjamanDAO.showData());
        tableView.refresh();
        btnSave.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        txt1.setDisable(false);
        txt1.clear();
        date1.setValue(null);
        date2.setValue(null);
        com1.setValue(null);
        com2.setValue(null);
    }

    public void buttonReset(ActionEvent actionEvent) {
        resetForm();
    }
    private void resetForm(){
        txt1.clear();
        date1.setValue(null);
        date2.setValue(null);
        com1.setValue(null);
        com2.setValue(null);
    }
    public void buttonMember(ActionEvent actionEvent) throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberManagement.fxml"));
        Parent root = fxmlLoader.load();
        com.example.kuis_1972003.MemberController c2 = fxmlLoader.getController();
        c2.setController(this);

        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("Member Management");
        new_stage.show();
    }

    public void buttonBook(ActionEvent actionEvent)throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bookManagement.fxml"));
        Parent root = fxmlLoader.load();
        com.example.kuis_1972003.BookController c2 = fxmlLoader.getController();
        c2.setController2(this);

        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("Book Management");
        new_stage.show();
    }

    public void fileClose(ActionEvent actionEvent) {
        stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void itemPil(MouseEvent event) {
        PeminjamanEntity peminjaman = tableView.getSelectionModel().getSelectedItem();
        txt1.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        btnReset.setDisable(false);
        txt1.setText(String.valueOf(tableView.getSelectionModel().getSelectedItem().getId()));
        date1.setValue(LocalDate.parse(String.valueOf(tableView.getSelectionModel().getSelectedItem().getTanggalPinjam())));
        date2.setValue(LocalDate.parse(String.valueOf(tableView.getSelectionModel().getSelectedItem().getTanggalPinjam())));
        com1.setValue(peminjaman.getAnggotaByAnggotaId());
        com2.setValue(peminjaman.getBukuByBukuId());
    }
}
