package edu.coderhouse.jpa;

import edu.coderhouse.jpa.model.Cliente;
import edu.coderhouse.jpa.model.DetalleFactura;
import edu.coderhouse.jpa.model.Factura;
import edu.coderhouse.jpa.model.Producto;
import edu.coderhouse.jpa.repository.DaoFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneApplication implements CommandLineRunner {
	@Autowired
	private DaoFactory<Cliente> daoCliente;
	@Autowired
	private DaoFactory<Producto> daoProducto;
	@Autowired
	private DaoFactory<Factura> daoFactura;
	@Autowired
	private DaoFactory<DetalleFactura> daoDetalleFactura;

	public OneApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
		System.out.println("Operación exitosa");
	}

	public void run(String... args) throws Exception {
		try {
			System.out.println("***************Lista de clientes inicial:***************");
			List<Cliente> clientes = this.daoCliente.findAll(Cliente.class);
			System.out.println("Número de clientes: " + clientes.size());

			for(int i = 0; i < clientes.size(); ++i) {
				Cliente user = (Cliente)clientes.get(i);
				System.out.println(user.toString());
			}

			System.out.println("***************Lista de productos inicial:***************");
			List<Producto> productos = this.daoProducto.findAll(Producto.class);
			System.out.println("Número de productos: " + productos.size());

			for(int i = 0; i < productos.size(); ++i) {
				Producto user = (Producto)productos.get(i);
				System.out.println(user.toString());
			}

			System.out.println("***************Lista de facturas inicial:***************");
			List<Factura> facturas = this.daoFactura.findAll(Factura.class);
			System.out.println("Número de facturas: " + facturas.size());

			for(int i = 0; i < clientes.size(); ++i) {
				Factura user = (Factura)facturas.get(i);
				System.out.println(user.toString());
			}

			System.out.println("---------------");
			System.out.println("CREACIÓN DE ENTIDADES NUEVAS:");
			Cliente clientePrueba = new Cliente("Cliente", "Prueba", "23042004");
			this.daoCliente.create(clientePrueba);
			Producto productoPrueba = new Producto("Laptop Gamer", "P006", 10, 1500.0);
			this.daoProducto.create(productoPrueba);
			Factura factura = new Factura(clientePrueba, 1500.0);
			this.daoFactura.create(factura);
			DetalleFactura detalleFactura = new DetalleFactura(factura, 2, productoPrueba, 1500.0);
			this.daoDetalleFactura.create(detalleFactura);
			System.out.println(clientePrueba.toString());
			System.out.println(productoPrueba.toString());
			System.out.println(factura.toString());
			System.out.println(detalleFactura.toString());
			System.out.println("---------------");
			System.out.println("***************Lista de clientes final:***************");
			List<Cliente> clientesAfter = this.daoCliente.findAll(Cliente.class);
			System.out.println("Número de clientes: " + clientesAfter.size());

			for(int i = 0; i < clientesAfter.size(); ++i) {
				Cliente user = (Cliente)clientesAfter.get(i);
				System.out.println(user.toString());
			}

			System.out.println("***************Lista de productos final:***************");
			List<Producto> productosAfter = this.daoProducto.findAll(Producto.class);
			System.out.println("Número de productos: " + productosAfter.size());

			for(int i = 0; i < productosAfter.size(); ++i) {
				Producto user = (Producto)productosAfter.get(i);
				System.out.println(user.toString());
			}

			System.out.println("***************Lista de facturas final:***************");
			List<Factura> facturasAfter = this.daoFactura.findAll(Factura.class);
			System.out.println("Número de facturas: " + facturasAfter.size());

			for(int i = 0; i < facturasAfter.size(); ++i) {
				Factura user = (Factura)facturasAfter.get(i);
				System.out.println(user.toString());
			}

			System.out.println("***************Lista de DetalleFactura final:***************");
			List<DetalleFactura> detalleFacturas = this.daoDetalleFactura.findAll(DetalleFactura.class);
			System.out.println("Número de facturas: " + detalleFacturas.size());

			for(int i = 0; i < detalleFacturas.size(); ++i) {
				DetalleFactura user = (DetalleFactura)detalleFacturas.get(i);
				System.out.println(user.toString());
			}
		} catch (Exception var15) {
			var15.printStackTrace(System.out);
		}

	}
}