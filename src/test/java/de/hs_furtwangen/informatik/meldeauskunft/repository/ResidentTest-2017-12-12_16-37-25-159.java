package de.hs_furtwangen.informatik.meldeauskunft.repository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.easymock.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;


public class ResidentTest {

	@Test
	public void testGetFilteredResidentLists() {
				
				BaseResidentService service = new BaseResidentService();
				ResidentRepository repository = createMock(ResidentRepository.class);
				java.util.Date date1 = new java.util.Date(1111111112);
				List<Resident> test = new ArrayList<Resident>();
				Resident r1 = new Resident("Lucas", "Hermann", "Hauptstrasse", "Furtwangen", date1);
				
				Resident r2 = new Resident("Martin", "Hermann", "Hauptstrasse", "Furtwangen", date1);
				
				Resident r3 = new Resident("Tom", "Patrick", "Hauptstrasse", "Furtwangen", date1);
				test.add(r1);
				test.add(r2);
				test.add(r3);
				
				expect(repository.getResidents()).andReturn(test);
				
				service.setResidentRepository(repository);
				
				
				replay(repository);
				Resident filter = new Resident("Martin", "Hermann", "", "", date1 );
				List<Resident> filtered = new ArrayList<Resident>();
				filtered.add(r2);
				
				
				assertThat(service.getFilteredResidentsList(filter), equalTo(filtered));
				verify(repository);		
				
				
				Resident filter2 = new Resident("", "Hermann", "", "", date1 );
				ArrayList<Resident> filtered2 = new ArrayList<Resident>();
				filtered2.add(r1);
				filtered2.add(r2);
				assertEquals(filtered2, service.getFilteredResidentsList(filter2));				
				
				Resident filter3 = new Resident("Tom", "", "", "", date1 );
				ArrayList<Resident> filtered3 = new ArrayList<Resident>();
				filtered3.add(r3);
				assertEquals(filtered3, service.getFilteredResidentsList(filter3));				
				
				
				
	}
	
	@Test(expected=ResidentServiceException.class, timeout=100)
	public void testGetUniqueResidentExce() throws ResidentServiceException {
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
	public void testgetUniqueResident() throws ResidentServiceException {
		
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
		assertEquals(r1, service.getUniqueResident(r1));
		
	}
	
}
