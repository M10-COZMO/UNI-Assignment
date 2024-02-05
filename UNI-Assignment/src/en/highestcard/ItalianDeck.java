package en.highestcard;

public enum ItalianDeck {
	
	ASSO(1),
	DUE(2),
	TRE(3),
	QUATTRO(4),
	CINQUE(5),
	SEI(6),
	SETTE(7),
	FANTE(8),
	CAVALLO(9),
	RE(10);
	
	final int cardValue;
	
	ItalianDeck (int _cardValue){
		this.cardValue = _cardValue;
	}

}
