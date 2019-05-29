package tdc.edu.vn.myapplication;

public class PhepTinh {
    private int anh;
    private String txtSo1;

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTxtSo1() {
        return txtSo1;
    }

    public void setTxtSo1(String txtSo1) {
        this.txtSo1 = txtSo1;
    }

    public String getTxtSo2() {
        return txtSo2;
    }

    public void setTxtSo2(String txtSo2) {
        this.txtSo2 = txtSo2;
    }

    public String getTxtKQ() {
        return txtKQ;
    }

    public void setTxtKQ(String txtKQ) {
        this.txtKQ = txtKQ;
    }

    public String getTxtPhepTinh() {
        return txtPhepTinh;
    }

    public void setTxtPhepTinh(String txtPhepTinh) {
        this.txtPhepTinh = txtPhepTinh;
    }

    private String txtSo2;
    private String txtKQ;
    private String txtPhepTinh;

    public PhepTinh(int anh, String txtSo1, String txtSo2, String txtKQ, String txtPhepTinh) {
        this.anh = anh;
        this.txtSo1 = txtSo1;
        this.txtSo2 = txtSo2;
        this.txtKQ = txtKQ;
        this.txtPhepTinh = txtPhepTinh;
    }

    public PhepTinh() {
    }

    ;


}
