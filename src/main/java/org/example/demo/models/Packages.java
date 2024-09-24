package org.example.demo.models;

import javafx.beans.property.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Packages {
    private SimpleIntegerProperty packageId;
    private SimpleStringProperty pkgName;
    private SimpleDateFormat pkgStartDate;
    private SimpleDateFormat pkgEndDate;
    private SimpleStringProperty pkgDesc;
    private SimpleDoubleProperty pkgBasePrice;
    private SimpleDoubleProperty pkgAgencyCommission;

    public Packages() {
        this.packageId = new SimpleIntegerProperty();
        this.pkgName = new SimpleStringProperty();
        this.pkgStartDate = new SimpleDateFormat();
        this.pkgEndDate = new SimpleDateFormat();
        this.pkgDesc = new SimpleStringProperty();
        this.pkgBasePrice = new SimpleDoubleProperty();
        this.pkgAgencyCommission = new SimpleDoubleProperty();
    }

    public int getPackageId() {
        return packageId.get();
    }

    public void setPackageId(int packageId) {
        this.packageId.set(packageId);
    }

    public String getPkgName() {
        return pkgName.get();
    }

    public void setPkgName(String pkgName) {
        this.pkgName.set(pkgName);
    }

    public String getPkgStartDate() {
        return pkgStartDate.format(new Date());
    }

    public void setPkgStartDate(Date pkgStartDate) {
        this.pkgStartDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getPkgEndDate() {
        return pkgEndDate.format(new Date());
    }

    public void setPkgEndDate(Date pkgEndDate) {
        this.pkgEndDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getPkgDesc() {
        return pkgDesc.get();
    }

    public void setPkgDesc(String pkgDesc) {
        this.pkgDesc.set(pkgDesc);
    }

    public double getPkgBasePrice() {
        return pkgBasePrice.get();
    }

    public void setPkgBasePrice(int pkgBasePrice) {
        this.pkgBasePrice.set(pkgBasePrice);
    }

    public double getPkgAgencyCommission() {
        return pkgAgencyCommission.get();
    }

    public void setPkgAgencyCommission(int pkgAgencyCommission) {
        this.pkgAgencyCommission.set(pkgAgencyCommission);
    }
}
