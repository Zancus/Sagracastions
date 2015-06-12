package com.Zanca.sagracastions.storia;

import com.Zanca.sagracastions.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class storiaFragment extends Fragment {

	private TextView storia;
	
	public static storiaFragment newInstance()
	{
		return new storiaFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View storia_view = inflater.inflate(R.layout.fragment_storia, container, false);
		storia = (TextView) storia_view.findViewById(R.id.txtStoria);
		storia.setText("L’associazione 'La Piazza' ha avuto origine a Castions una ventina di anni fa per volontà di alcuni giovanotti in gamba e con lo scopo principale di rinverdire e rinnovare le antiche e sane tradizioni popolari paesane." +
					   "L’associazione lavora tutto l’anno e l’impegno via via profuso si riassume in buona parte nello svolgimento dei festeggiamenti al Parco Burgos, le due ultime settimane di agosto." +
					   "Abitualmente durante i festeggiamenti la gente locale ha potuto godere ed assaporare buona musica, giochi, cibo, fiorentine, buon vino, ottima birra, bibite, lotteria, pedalate in bicicletta, presentazione di libri, la Messa, il pranzo paesano…  insomma, una SAGRA, ossia una festa popolare!" +
					   "Una sorta di sgancio dalla normale quotidianità per tutti gli aderenti e che ci permette di relazionare, incontrare e mantenere un contatto più fisico ed umano con 'Cjasteons e la so zent'." +
					   "Al gruppo dei consiglieri dell’associazione La Piazza che crea, pre-organizza e sviluppa i festeggiamenti, è demandato l’ardua impresa di coordinare oltre un centinaio di persone, dai sette otto anni in su, impegnate  nei vari compiti assegnati." +
					   "Dodici mesi all’anno di vita associativa dedicati tra un’edizione di sagra e l’altra; ma c’è di più: come la gestione del parco, della quale La Piazza si è fatta carico nei confronti del comune di Zoppola, con lo sfalcio dell’erba, la potatura del verde, il mantenimento dei vialetti, manutenzioni ordinarie e, purtroppo spesso, la sistemazione di atti vandalici ai quali il parco e le sue strutture sono soggette. Contiamo che il nostro esempio diventi educativo per chi non sa ancora rispettare i beni della comunità.");
		
		return storia_view;
	}
}
