package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsSelectionImpl;

public class MeuTesteIncrivel {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public OrderStatistics<Integer> implementation;

	@Before
	public void setUp() {
		this.vetorTamPar = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		this.vetorTamImpar = new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		this.vetorValoresRepetidos = new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 };
		this.vetorValoresIguais = new Integer[] { 6, 6, 6, 6, 6, 6 };

		this.implementation = new OrderStatisticsSelectionImpl<>();
	}

	@Test
	public void test01K1() {
		Assert.assertEquals(Integer.valueOf(4), this.implementation.getOrderStatistics(vetorTamImpar, 1));
	}

	@Test
	public void test02K1() {
		Assert.assertEquals(Integer.valueOf(6), this.implementation.getOrderStatistics(vetorValoresIguais, 1));
	}

	@Test
	public void test03K1() {
		Assert.assertEquals(Integer.valueOf(0), this.implementation.getOrderStatistics(vetorValoresRepetidos, 1));
	}



	@Test
	public void test01K2() {
		Assert.assertEquals(Integer.valueOf(6), this.implementation.getOrderStatistics(vetorTamImpar, 2));
	}

	@Test
	public void test02K2() {
		// todos são iguais, então o segundo menor é nenhum
		Assert.assertEquals(null, this.implementation.getOrderStatistics(vetorValoresIguais, 2));
	}

	@Test
	public void test03K2() {
		Assert.assertEquals(Integer.valueOf(1), this.implementation.getOrderStatistics(vetorValoresRepetidos, 2));
	}



	@Test
	public void test01K4() {
		Assert.assertEquals(Integer.valueOf(11), this.implementation.getOrderStatistics(vetorTamImpar, 4));
	}

	@Test
	public void test02K4() {
		// todos são iguais, então o quarto menor é nenhum
		Assert.assertEquals(null, this.implementation.getOrderStatistics(vetorValoresIguais, 4));
	}

	@Test
	public void test03K4() {
		Assert.assertEquals(Integer.valueOf(4), this.implementation.getOrderStatistics(vetorValoresRepetidos, 4));
	}


	@Test
	public void test01K7() {
		Assert.assertEquals(Integer.valueOf(32), this.implementation.getOrderStatistics(vetorTamImpar, 7));
	}

	@Test
	public void test01K10() {
		Assert.assertEquals(Integer.valueOf(31), this.implementation.getOrderStatistics(vetorTamPar, 10));
	}


	@Test
	public void testVazio() {
		Assert.assertEquals(null, this.implementation.getOrderStatistics(vetorVazio, 1));
		Assert.assertEquals(null, this.implementation.getOrderStatistics(vetorVazio, 2));
		Assert.assertEquals(null, this.implementation.getOrderStatistics(vetorVazio, 3));
	}
}