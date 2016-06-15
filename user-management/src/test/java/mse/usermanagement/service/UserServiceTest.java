package mse.usermanagement.service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test for {@link UserService}.
 * 
 * @author Radostin Ivanov
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	private UserService userService;

	@Mock
	private EntityManager entityManager;

	@Mock
	private TypedQuery<Long> typedQuery;

	@Before
	public void init() {
		userService = new UserService();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPageCountWithZeroUsers() {
		verifyPageCountWithGivenUserCount(0, 1);

	}

	@Test
	public void testPageCountWithManyUsers() {
		verifyPageCountWithGivenUserCount(22, 6);

	}

	@Test
	public void testPageCountWithUsersLessThanPageSize() {
		verifyPageCountWithGivenUserCount(2, 1);

	}

	private void verifyPageCountWithGivenUserCount(long count, int expectedPageCount) {
		Mockito.when(typedQuery.getSingleResult()).thenReturn(count);

		Mockito.when(entityManager.createNamedQuery("User.count", Long.class)).thenReturn(typedQuery);

		int result = userService.getPageCount();

		Assert.assertEquals(expectedPageCount, result);

	}
}
