
public class InstructionSet {
	
	public static void OR(int[] accumulator, int[] reg, int[] statusRegister){
	
		int count = 0;
		
		for(int i = 0; i < reg.length; i++){
			accumulator[i] = accumulator[i]|reg[i];
			
			if(accumulator[i] == 0)
				count++;
				
		}
		
		if(count == (accumulator.length-1))
			statusRegister[0] = 1;
		else if(accumulator[accumulator.length-1] == 1)
			statusRegister[2] = 1;
 }
	
	public static void SUB(int[] accumulator, int[] reg, int[] statusRegister){
		twosComplement(reg);
		//ADDC(accumulator, reg, statusRegister);
	}
	
	public static void twosComplement(int[] arr){
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1 && count == 0)
				count++;
			else if (count == 1){
				if(arr[++i] == 0)
					arr[i] = 1;
				else
					arr[i] = 0;
				
			}
     }
}
	
	public static void NEG(int[] accumulator, int[] statusRegister){
		twosComplement(accumulator);
		
		if(accumulator[accumulator.length-1] == 1)
			statusRegister[2] = 1;
	}
	
	public static void RLC(int[] accumulator, int[] statusRegister){
		int count = 0;
		int carry = statusRegister[1];
		statusRegister[1] = accumulator[accumulator.length-1];
		accumulator[0] = carry;
		if(accumulator[0] == 0)
			count++;
		
		for(int i = (accumulator.length - 1); i > 0; i++){
			accumulator[i] = accumulator[i-1];
			
			if(accumulator[i] == 0)
				count++;
		}
		
		if(accumulator[accumulator.length-1] == 1)
			statusRegister[1] = 1;
		
		if(count == accumulator.length)
			statusRegister[0] = 0;
		
	}
	
	public static void LDA(int[] accumulator, int[] mem, int[] statusRegister){
		int count = 0;
		
		for(int i = 0; i < mem.length; i++){
			accumulator[i] = mem[i];
			
			if(accumulator[i] == 0){
				count++;
			}
		}
		
		if(accumulator[accumulator.length - 1] == 1)
			statusRegister[1] = 1;
		
		if(count == accumulator.length)
			statusRegister[0] = 0;
	}
	
	public static void LDI(int[] accumulator, int[] mem, int[] statusRegister){
		int count = 0;
		
		for(int i = 0; i < mem.length; i++){
			accumulator[i] = mem[i];
			
			if(accumulator[i] == 0){
				count++;
			}
		}
		
		if(accumulator[accumulator.length - 1] == 1)
			statusRegister[1] = 1;
		
		if(count == accumulator.length)
			statusRegister[0] = 0;
	}
	
	public static void BRC(int[] statusRegister, int[] reg7, int[] programCounter){
		if(statusRegister[1] == 1){
			for(int i = 0; i < reg7.length; i++){
				programCounter[i] = reg7[i];
			}
				
		}
	}
		
		public static void BRO(int[] statusRegister, int[] reg7, int[] programCounter){
			if(statusRegister[3] == 1){
				for(int i = 0; i < reg7.length; i++){
					programCounter[i] = reg7[i];
				}
					
			}
				
	}
		
		public static void NOP(){
			
		}
	

}
