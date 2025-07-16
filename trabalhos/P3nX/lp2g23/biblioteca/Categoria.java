package lp2g23.biblioteca;

public enum Categoria{
        ADMINISTRACAO(1),
        ARTE(2),
	ARTESANATO(3),
        AUTOAJUDA(4),
        BIOGRAFIA(5),
        CINEMA(6),
        CIENCIAS(7),
        COMPUTACAO(8),
	DIREITO(9),
        ENGENHARIA(10),
	ESPORTES(11),
	FICÇAO(12),
	FILOSOFIA(13),
        FOTOGRAFIA(14),
        FANTASIA(15),
        GASTRONOMIA(16),
	HISTORIA(17),
	HQ(18),
	INFANTIL(19),
	MEDICINA(20),
	POLITICA(21),
	RELIGIAO(22),
	ROMANCE(23),
	SUSPENSE(24),
	TERROR(25),
	VIAGENS(26);
	
        private final int categNumero;

        Categoria(int num){
                this.categNumero = num;
        }

        public int getCategNumero(){
                return categNumero;
        }
} 
