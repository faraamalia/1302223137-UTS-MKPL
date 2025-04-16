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

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean hasSpouse, int numOfDependents) {
        int nonTaxableIncome = calculateNonTaxableIncome(hasSpouse, numOfDependents);
        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        return (int) Math.round(0.05 * (totalIncome - deductible - nonTaxableIncome));
    }

    private static int calculateNonTaxableIncome(boolean hasSpouse, int numOfChildren) {
        int nonTaxableIncome = 54000000; 
        if (hasSpouse) {
            nonTaxableIncome += 4500000; 
        }
        if (numOfChildren > 0) {
            nonTaxableIncome += Math.min(3, numOfChildren) * 1500000; 
        }
        return nonTaxableIncome;
    }
}

