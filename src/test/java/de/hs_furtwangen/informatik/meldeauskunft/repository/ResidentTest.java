package de.hs_furtwangen.informatik.meldeauskunft.repository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;


//Integrationstest mit Stub


public class ResidentTest {

	//3 Testfälle für GetFilteredResident - Beispiele mit Stub
	
	
	@Test
	public void testGetFilteredResidentLists4() {
				
			BaseResidentService service = new BaseResidentService();
			ResidentRepository repository = new ResidentRepositoryStub();
			java.util.Date date1 = new java.util.Date(1111111112);
			Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
			repository.addResident(r1);
			Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
			repository.addResident(r2);
			Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
			repository.addResident(r3);
			service.setResidentRepository(repository);
				
			Resident filter = new Resident("Martin", "Hermann", "", "", date1 );
			List<Resident> filtered = new ArrayList<Resident>();
			filtered.add(r2);
			assertEquals(filtered, service.getFilteredResidentsList(filter));
		
								
	}
	
	
	@Test
	public void testGetFilteredResidentLists5() {
				
		BaseResidentService service = new BaseResidentService();
		ResidentRepository repository = new ResidentRepositoryStub();
		java.util.Date date1 = new java.util.Date(1111111112);
		Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r1);
		Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r2);
		Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r3);
		service.setResidentRepository(repository);
			
				
		Resident filter = new Resident("Tom", "", "", "", date1 );
		List<Resident> filtered = new ArrayList<Resident>();
		filtered.add(r3);
				
		assertEquals(filtered, service.getFilteredResidentsList(filter));
				
	}
	
	
	@Test
	public void testGetFilteredResidentLists6() {
				
		
		BaseResidentService service = new BaseResidentService();
		ResidentRepository repository = new ResidentRepositoryStub();
		java.util.Date date1 = new java.util.Date(1111111112);
		Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r1);
		Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r2);
		Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r3);
		service.setResidentRepository(repository);
			
		Resident filter = new Resident("", "Hermann", "", "", date1 );
		List<Resident> filtered = new ArrayList<Resident>();
		filtered.add(r1);
		filtered.add(r2);
				
		assertEquals(filtered, service.getFilteredResidentsList(filter));
	}
		
	
	//3 Testfälle für GetUniqueResident - Beispiele mit Stub
	
	@Test(expected=ResidentServiceException.class, timeout=100)
	public void testGetUniqueResident1() throws ResidentServiceException {
		BaseResidentService service = new BaseResidentService();
		ResidentRepository repository = new ResidentRepositoryStub();
		java.util.Date date1 = new java.util.Date(1111111112);
		Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r1);
		
		Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r2);
		Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r3);
		Resident r4 = new Resident("Tom", "Tom", "Hauptstrasse", "Furtwangen", date1);
		service.setResidentRepository(repository);
		
		service.getUniqueResident(r4);
		
	}
	
	
	@Test
	public void testgetUniqueResident2() throws ResidentServiceException {
		
		BaseResidentService service = new BaseResidentService();
		ResidentRepository repository = new ResidentRepositoryStub();
		java.util.Date date1 = new java.util.Date(1111111112);
		Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r1);
		Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r2);
		Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r3);
		service.setResidentRepository(repository);
		
		assertEquals(r1, service.getUniqueResident(r1));
		
	}
	
	
	@Test
	public void testgetUniqueResident3() throws ResidentServiceException {
		
		BaseResidentService service = new BaseResidentService();
		ResidentRepository repository = new ResidentRepositoryStub();
		java.util.Date date1 = new java.util.Date(1111111112);
		Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r1);
		Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r2);
		Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
		repository.addResident(r3);
		service.setResidentRepository(repository);
		
		assertEquals(r3, service.getUniqueResident(r3));
		
	}
	
}
