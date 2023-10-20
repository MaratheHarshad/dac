package generics;

import java.util.ArrayList;
import java.util.Vector;

import com.app.core.Mgr;
import com.app.core.SalesMgr;

import static utils.GenericUtils.*;

public class Test5 {

	public static void main(String[] args) {
		ArrayList<Mgr> mgrs=new ArrayList<>();
		mgrs.add(new Mgr(1000));
		mgrs.add(new Mgr(2000));
		mgrs.add(new Mgr(3000));
		System.out.println("sum ="+sumOfSalaries(mgrs));
		//Vector<SalesMgr> : Try itSalesMgrrk)
		
		Vector<SalesMgr> slsMgrs = new Vector<>();
		slsMgrs.add(new SalesMgr(1000));
		slsMgrs.add(new SalesMgr(2000));
		slsMgrs.add(new SalesMgr(3000));
		slsMgrs.add(new SalesMgr(4000));
		
		
		System.out.println("sum = " + sumOfSalaries(slsMgrs));

	}

}
