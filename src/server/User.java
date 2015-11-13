package server;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "user")
public class User
{	
	private String login;
	private String fName;
	private String lName;
	private String pw;
	@XmlElement
	private String ip;
	private boolean online;
	private int inPort;
	private int outPort;


	public User(String login, String fName, String lName, String pw,  InetAddress ip)
	{		
		this.login = login;
		this.fName = fName;
		this.lName = lName;
		this.pw = pw;
		this.ip = ip.getHostAddress();
		this.online = true;
		this.outPort = MakeOutPort();
		this.inPort = MakeInPort();		
	}
	
	public int MakeInPort()
	{
		int port;
		port = getOutPort();
		if(port == 65535 )
			port -= 1;
		else
			port += 1;		
		return port;
	}
	
	public int MakeOutPort()
	{
		Random rng = new Random();
		int port;
		port = rng.nextInt(16383) + 49152;
		return port;
	}
	
	public int getInPort()
	{
		return inPort;
	}

	public void setInPort(int inPort)
	{
		this.inPort = inPort;
	}

	public int getOutPort()
	{
		return outPort;
	}

	public void setOutPort(int outPort)
	{
		this.outPort = outPort;
	}

	public User() 
	{
		super();
	}
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getfName()
	{
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName(String lName)
	{
		this.lName = lName;
	}

	public String getPw()
	{
		return pw;
	}
	public void setPw(String pw)
	{
		this.pw = pw;
	}
	
	public String getIp()
	{
		return ip;
	}

	public void setIp(InetAddress ip)
	{
		this.ip = ip.getHostAddress();
	}

	public boolean getOnline()
	{
		return online;
	}
	
	public void setOnline(boolean online)
	{
		this.online = online;
	}
	
	@Override
	public String toString() 
	{ 
	    return "login: '" + this.login + "', fName: '" + this.fName + "', lName: '" + this.lName + "', IP: '" + this.ip + "'";
	} 
}