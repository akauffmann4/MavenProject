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


//Integrationstest mit Mock 


public class ResidentTestMitMock {

	
	//3 Testfälle für GetFilteredResident - Beispiele mit Mock
	
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
								
	}
	
	
	@Test
	public void testGetFilteredResidentLists2() {
				
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
				Resident filter = new Resident("Tom", "", "", "", date1 );
				List<Resident> filtered = new ArrayList<Resident>();
				filtered.add(r3);
				
				
				assertThat(service.getFilteredResidentsList(filter), equalTo(filtered));
				
				verify(repository);	
				
	}
	
	
	@Test
	public void testGetFilteredResidentLists3() {
				
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
				Resident filter = new Resident("", "Hermann", "", "", date1 );
				List<Resident> filtered = new ArrayList<Resident>();
				filtered.add(r1);
				filtered.add(r2);
				
				
				assertThat(service.getFilteredResidentsList(filter), equalTo(filtered));
				
				verify(repository);
				
		
	}
	
	
	
	
	//3 Testfälle für GetUniqueResident - Beispiele mit Mock
	
		@Test
		public void testGetUniqueResident1() throws ResidentServiceException {
			
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
			
			
			assertThat(service.getUniqueResident(r1), equalTo(r1));
			
			verify(repository);
			
			
			
		}
		
		
		@Test
		public void testgetUniqueResident2() throws ResidentServiceException {
			
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
			
			
			assertThat(service.getUniqueResident(r2), equalTo(r2));
			
			verify(repository);
			
		}
		
		
		@Test
		public void testgetUniqueResident3() throws ResidentServiceException {
			
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
			
			
			assertThat(service.getUniqueResident(r3), equalTo(r3));
			
			verify(repository);
			
		}
		
		
	
}
