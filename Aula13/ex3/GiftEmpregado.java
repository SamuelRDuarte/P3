package Aula13.ex3;
import java.util.*;
import java.util.stream.Collectors;

public class GiftEmpregado {
	private Map<String,List<String>> empgifts = new TreeMap<>();
	
	public void oferecer(String gift,String empre) {
		if (empgifts.containsKey(empre)) {
			empgifts.get(empre).add(gift);
		} else {
			List<String> nova = new LinkedList<>();
			nova.add(gift);
			empgifts.put(empre, nova);
		}
	}
	
	public boolean removeGift(String emp) {
		if (empgifts.containsKey(emp)) {
			List<String> tmp = empgifts.get(emp);
			tmp.remove(tmp.size()-1);
			if(tmp.size()==0)empgifts.remove(emp);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return empgifts.keySet().stream().map(s->s.concat("->").concat(empgifts.get(s).toString())).collect(Collectors.joining("\n"));
	}
}
