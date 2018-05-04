package DoiTuong;

/**
 * Created by danh on 13/04/2018.
 */

public class MeoVat {
    private int id;
    private String tieude;
    private byte[] urlImage;
    private String chitiet;

    public MeoVat(int id, String tieude, byte[] urlImage, String chitiet) {
        this.id = id;
        this.tieude = tieude;
        this.urlImage = urlImage;
        this.chitiet = chitiet;
    }

    public MeoVat(String tieude, byte[] urlImage, String chitiet) {
        this.tieude = tieude;
        this.urlImage = urlImage;
        this.chitiet = chitiet;
    }

    public MeoVat(int id, String tieude, byte[] urlImage) {
        this.id = id;
        this.tieude = tieude;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public byte[] getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(byte[] urlImage) {
        this.urlImage = urlImage;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }
}
