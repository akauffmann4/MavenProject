package de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.util.ArrayList;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {

	private List<Resident> residents = new ArrayList<Resident>();
	  

	  
	  public void addResident(Resident r) {
		  residents.add(r);
	  }



	public List<Resident> getResidents() {
		return residents;
	}

	
}

