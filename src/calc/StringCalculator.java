package calc;

import java.util.ArrayList;

public class StringCalculator {

	public static void main(String[] args) {

	}
	
	public int add(String n) throws Exception{
		int res = 0;
		if(!n.equals("")){
			String[] splitArgs = n.split("//");
			String[] splitNums;
			String nums;
			String separatorRegex;
			if(splitArgs.length == 2){
				separatorRegex = splitArgs[1].split("[\\n]")[0];
				nums = splitArgs[1].split("[\\n]")[1];
				separatorRegex = separatorRegex.replace("[", "").replace("]", "");
			}
			else{
				separatorRegex = "[\\n,]";
				nums = splitArgs[0];
			}
			splitNums = nums.split(separatorRegex);
			ArrayList<Integer> negatives = new ArrayList<Integer>();
			try{
				for(String num : splitNums){
					int nextAdd = Integer.parseInt(num);
					if(nextAdd < 0){
						negatives.add(nextAdd);
					}
					else if(negatives.size() == 0 && nextAdd <= 1000){
						res += nextAdd;
					}
				}
				if(negatives.size() > 0){
					StringBuilder negs = new StringBuilder();
					negs.append(negatives.get(0));
					for(int i = 1; i < negatives.size(); i++){
						negs.append(", ");
						negs.append(negatives.get(i));
					}
					throw new Exception("Negatives not allowed: " + negs.toString());
				}
			}
			catch(NumberFormatException e){
				return 0;
			}
		}
		return res;
	}

}