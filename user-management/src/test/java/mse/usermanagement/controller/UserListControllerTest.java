package mse.usermanagement.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link UserListController}.
 * 
 * @author Radostin Ivanov
 *
 */
public class UserListControllerTest {
	private UserListController controller;

	@Before
	public void init() {
		controller = new UserListController();
	}

	@Test
	public void testPrevLinkDisabledOnFirstPage() {
		controller.setPage(1);

		boolean enabled = controller.isPrevEnabled();
		Assert.assertFalse(enabled);
	}

	@Test
	public void testPrevLinkEnabledOnSecondPage() {
		controller.setPage(2);

		boolean enabled = controller.isPrevEnabled();
		Assert.assertTrue(enabled);
	}

	@Test
	public void testNextLinkDisabledOnLastPage() {
		controller.setPageCount(5);
		controller.setPage(5);
		boolean enabled = controller.isNextEnabled();
		Assert.assertFalse(enabled);
	}

	@Test
	public void testNextLinkDisabledOnNonLastPage() {
		controller.setPageCount(5);
		controller.setPage(4);
		boolean enabled = controller.isNextEnabled();
		Assert.assertTrue(enabled);
	}

	@Test
	public void testPagesWhenOnFirstPage() {
		testGetPages(10, 1, new Integer[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testPagesWhenOnSecondPage() {
		testGetPages(10, 2, new Integer[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testPagesWhenOnSecondLastPage() {
		testGetPages(10, 9, new Integer[] { 6, 7, 8, 9, 10 });
	}

	@Test
	public void testPagesWhenOnLastPage() {
		testGetPages(10, 10, new Integer[] { 6, 7, 8, 9, 10 });
	}

	@Test
	public void testPagesWhenOnTheMiddle() {
		testGetPages(10, 5, new Integer[] { 3, 4, 5, 6, 7 });
	}

	@Test
	public void testPagesWhenPageCountIsLessThanMaxPages() {
		testGetPages(3, 1, new Integer[] { 1, 2, 3 });
	}

	private void testGetPages(int pages, int currentPage, Integer expectedResult[]) {
		controller.setPageCount(pages);
		controller.setPage(currentPage);
		List<Integer> result = controller.getPages();
		Assert.assertArrayEquals(expectedResult, result.toArray(new Integer[0]));
	}
}
