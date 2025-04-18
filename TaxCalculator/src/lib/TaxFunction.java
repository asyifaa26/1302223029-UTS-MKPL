package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        validateInputs(numberOfMonthWorking);

        int taxRelief = getTaxRelief(isMarried, numberOfChildren);
        int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int taxableIncome = annualIncome - deductible - taxRelief;

        int tax = (int) Math.round(0.05 * taxableIncome);
        return Math.max(tax, 0);
    }

    private static void validateInputs(int numberOfMonthWorking) {
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
    }

    private static int getTaxRelief(boolean isMarried, int numberOfChildren) {
        final int BASE_RELIEF = 54000000;
        final int MARRIED_RELIEF = 4500000;
        final int CHILD_RELIEF = 1500000;

        int relief = BASE_RELIEF;
        if (isMarried) {
            relief += MARRIED_RELIEF;
        }

        relief += CHILD_RELIEF * Math.min(3, numberOfChildren);
        return relief;
    }
	
}
