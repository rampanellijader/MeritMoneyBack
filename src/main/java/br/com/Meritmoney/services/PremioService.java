package br.com.Meritmoney.services;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.entities.Premio;
import br.com.Meritmoney.repositories.PremioRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Service
public class PremioService {

	@Autowired
	private PremioRepository repository;
	
	public List<Premio> findAll(){		
		return repository.findAll();
	}
	
	public Premio findByID(Integer id) {		
		Premio obj = repository.findById(id).orElse(null);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não localizado!");
		}		
		return obj;
	}
		
	public void deleteByID(Integer id) {
		if (id == null) {
			throw new ObjectNotFoundException("Objeto não localizado!");
		}
		repository.deleteById(id);		
	}
	
	public Premio save(Premio premio) {		
		return repository.saveAndFlush(premio);
	}
	
	//buscar premio por nome
	public Premio findByNome(String nome){
		Premio obj = repository.findByNome(nome);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não localizado!");
		}		
		return obj;
	}	
	
	
	public void enviaEmail(String emailUsuario, String emailRH, String textoEmail) {
		Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", 
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	 
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() 
	           {
	                 return new PasswordAuthentication("CoopCoinTcc@gmail.com", 
	                 "tccSenac123");
	           }
	      });
	 
	    /** Ativa Debug para sessão */
	    session.setDebug(true);
	 
	    try {
	 
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("CoopCoinTcc@gmail.com")); 
	      //Remetente
	 
	      Address[] toUser = InternetAddress //Destinatário(s)
	                 .parse( emailUsuario + "," + emailRH);  
	 
	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("[CoopCoin] - Solicitação de prêmio");//Assunto
	      message.setText(textoEmail);
	      /**Método para enviar a mensagem criada*/
	      Transport.send(message);
	 
	      System.out.println("Feito!!!");
	 
	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	
}