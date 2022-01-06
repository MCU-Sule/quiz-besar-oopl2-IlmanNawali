/**
 * 1972003 Ilman Nawali
 */
package com.example.kuis_1972003;

import com.example.DAO.BookDAO;
import com.example.DAO.MemberDAO;
import com.example.Model.AnggotaEntity;
import com.example.Model.BukuEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class MemberController implements Initializable {
    public TableView<AnggotaEntity> tableView;
    public TableColumn<AnggotaEntity, String> col1;
    public TableColumn<AnggotaEntity, String> col2;
    public TableColumn<AnggotaEntity, String> col3;
    public TableColumn<AnggotaEntity, String> col4;
    public TableColumn<AnggotaEntity, String> col5;
    public TextField txt1;
    public TextField txt2;
    public TextField txt3;
    public DatePicker date1;
    public DatePicker date2;
    public Button btn1;

    private ObservableList<AnggotaEntity> anggotas;

    private Main controller;
    public void setController (Main controller){
        tableView.setItems(controller.getAnggotas());
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MemberDAO memberDAO = new MemberDAO();
        anggotas = (ObservableList<AnggotaEntity>) memberDAO.showData();
        tableView.setItems(anggotas);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNama())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNotelpon())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglLahir())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglMasuk())));
    }

    public void saveButton(ActionEvent actionEvent) {
        AnggotaEntity anggota =new AnggotaEntity();
        anggota.setId(Integer.valueOf(txt1.getText()));
        anggota.setNama(txt2.getText());
        anggota.setNotelpon(txt3.getText());
        anggota.setTglLahir(Date.valueOf(date1.getValue()));
        anggota.setTglMasuk(Date.valueOf(date2.getValue()));
        MemberDAO memberDAO = new MemberDAO();
        memberDAO.addData(anggota);
        controller.getAnggotas().clear();
        controller.getAnggotas().addAll(memberDAO.showData());
        tableView.refresh();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        date1.setValue(null);
        date2.setValue(null);
    }
}
