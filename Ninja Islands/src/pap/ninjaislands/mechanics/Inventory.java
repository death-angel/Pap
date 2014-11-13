package pap.ninjaislands.mechanics;

public class Inventory {

	public int number_of_weapons;
	
	public String[] weapons_name = new String[number_of_weapons];
	public String[] weapons_src = new String[number_of_weapons];
	public int[] weapons_damage = new int[number_of_weapons];
	public int[] weapons_ammunition = new int[number_of_weapons];
	
	
	public Inventory(int number_of_weapons){
		this.number_of_weapons = number_of_weapons;
		//nomes das armas
		weapons_name[0] = "Hands";
		weapons_name[1] = "Katana";
		weapons_name[2] = "Bow";
		//nome dos ficheiros
		weapons_src[0] = weapons_name[0]+".png";
		weapons_src[1] = weapons_name[1]+".png";
		weapons_src[2] = weapons_name[2]+".png";
		//quantidade de dano
		weapons_damage[0] = 0;
		weapons_damage[1] = 15;
		weapons_damage[2] = 10;
		//munição de cada arma
		weapons_ammunition[0] = 2; //2 mãos
		weapons_ammunition[1] = 1; //1 katana
		weapons_ammunition[2] = 5; //5 flexas
		
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
	}
	
	
}
