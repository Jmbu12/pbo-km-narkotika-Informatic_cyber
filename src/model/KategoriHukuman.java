package model;

public enum KategoriHukuman {
    RINGAN("Ringan", 0, 12),
    SEDANG("Sedang", 13, 60),
    BERAT("Berat", 61, Integer.MAX_VALUE);

    private final String label;
    private final int batasBawahBulan;
    private final int batasAtasBulan;

    KategoriHukuman(String label, int batasBawahBulan, int batasAtasBulan) {
        this.label = label;
        this.batasBawahBulan = batasBawahBulan;
        this.batasAtasBulan = batasAtasBulan;
    }

    public String getLabel() {
        return label;
    }

    public static KategoriHukuman dariBulan(int vonisBulan) {
        for (KategoriHukuman k : values()) {
            if (vonisBulan >= k.batasBawahBulan && vonisBulan <= k.batasAtasBulan) {
                return k;
            }
        }
        return SEDANG; // fallback aman
    }
}
