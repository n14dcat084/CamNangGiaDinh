package DoiTuong;

/**
 * Created by danh on 15/04/2018.
 */

public class MonChien {
    private int id;
    private String tieude;
    private byte[] url;
    private String chitiet;
    private int idLoaiMon;

    public MonChien(int id, String tieude, byte[] url, String chitiet, int idLoaiMon) {
        this.id = id;
        this.tieude = tieude;
        this.url = url;
        this.chitiet = chitiet;
        this.idLoaiMon = idLoaiMon;
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

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public int getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(int idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }
}
