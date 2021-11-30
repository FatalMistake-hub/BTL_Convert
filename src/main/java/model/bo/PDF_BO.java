package model.bo;

import java.util.List;

import model.bean.PDF;

public class PDF_BO {
	model.dao.PDF_DAO data = new model.dao.PDF_DAO();

    public List<PDF> getURLbyUser(String user) {
        return data.getURLbyUser(user);
    }

    public void addDOC(PDF pdf) {
        data.addDOC(pdf);
    }

    public PDF getURLByID(Integer ID) {
        return data.getURLByID(ID);
    }

    public void setURLResult(String sourcePath, Integer result) {
        data.setURLResult(sourcePath, result);
    }
}
