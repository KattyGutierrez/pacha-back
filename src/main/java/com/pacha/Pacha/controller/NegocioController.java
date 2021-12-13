package com.pacha.Pacha.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pacha.Pacha.bean.CompradorBean;
import com.pacha.Pacha.bean.FotoBean;
import com.pacha.Pacha.bean.NegocioBean;
import com.pacha.Pacha.bean.ProductoBean;
import com.pacha.Pacha.bean.RequestMPBean;
import com.pacha.Pacha.bean.UsuarioBean;
import com.pacha.Pacha.bean.VentaBean;
import com.pacha.Pacha.entity.Categoria;
import com.pacha.Pacha.entity.Comprador;
import com.pacha.Pacha.entity.DetalleVP;
import com.pacha.Pacha.entity.Negocio;
import com.pacha.Pacha.entity.Producto;
import com.pacha.Pacha.entity.TipoNegocio;
import com.pacha.Pacha.service.CategoriaService;
import com.pacha.Pacha.service.CompradorService;
import com.pacha.Pacha.service.NegocioService;
import com.pacha.Pacha.service.ProductoService;
import com.pacha.Pacha.service.TipoNegocioService;
import com.pacha.Pacha.service.UsuarioService;
import com.pacha.Pacha.service.VentaService;


@RestController
@CrossOrigin("*")
public class NegocioController {
	
	@Autowired
	UsuarioService uService;
	
	@Autowired
	TipoNegocioService tnService;
	
	@Autowired
	NegocioService nService;
	
	@Autowired
	ProductoService pService;
	
	@Autowired
	CategoriaService cService;
	
	@Autowired
	CompradorService coService;
	
	@Autowired
	VentaService vService;
	
	@GetMapping({"/tipoNegocio"})
	public Iterable<TipoNegocio> consultaTipoNegocio() {
		return tnService.getTipoNegocios();
	}
	
	@GetMapping({"/tipoNegocio/{id}"})
	public TipoNegocio consultaTipoNegocio(@PathVariable Long id) {
		return tnService.getTipoNegocio(id);
	}
	@GetMapping({"/negocioByTipo/{id_tipo}"})
	public Iterable<Negocio> consultaNegocioByTipo(@PathVariable Long id_tipo) {
		return nService.getNegociosByTipo(id_tipo);
	}
	@GetMapping({"/negocio/{id}"})
	public Negocio consultaNegocio(@PathVariable Long id) {
		return nService.getNegocio(id);
	}
	@GetMapping({"/comprador/{id}"})
	public Comprador consultaComprador(@PathVariable Long id) {
		return coService.getComprador(id);
	}
	@GetMapping({"/productosByNegocio/{id_negocio}"})
	public Iterable<Producto> consultaProductoByNegocio(@PathVariable Long id_negocio) throws FileNotFoundException, SQLException, IOException {
		return pService.getProductosByNegocio(id_negocio);
	}
	@GetMapping({"/categoria"})
	public Iterable<Categoria> consultaCategoria() {
		return cService.getCategorias();
	}
	@GetMapping({"/productosByCategoria/{id_negocio}/{id_categoria}"})
	public Iterable<Producto> consultaProductoByCategoria(@PathVariable Long id_negocio, @PathVariable Long id_categoria) throws FileNotFoundException, SQLException, IOException {
		return pService.getProductosByCategoriaNegocio(id_categoria, id_negocio);
	}
	
	@GetMapping({"/producto/{id}"})
	public Producto consultaProducto(@PathVariable Long id) throws FileNotFoundException, SQLException, IOException {
		return pService.getProducto(id);
	}
	
	@PostMapping({"/registrar/n"})
	public Negocio registrarNegocio(@RequestBody NegocioBean nb) {
		return nService.registrar(nb);
	}
	@PostMapping({"/registrar/c"})
	public Comprador registrarComprador(@RequestBody CompradorBean cb) {
		return coService.registrar(cb);
	}
	
	@PostMapping({"/nuevoProducto/{id_negocio}"})
	public Producto nuevoProducto(@PathVariable Long id_negocio,@RequestBody ProductoBean pb) {
		return pService.agregarProducto(id_negocio,pb);
	}
	
	@PostMapping({"/modificarProducto/{id_producto}"})
	public Producto modificarProducto(@PathVariable Long id_producto, @RequestBody ProductoBean pb) {
		return pService.modificarProducto( pb,id_producto);
	}
	
	@DeleteMapping({"/eliminarProducto/{id_producto}"})
	public Producto eliminarProducto(@PathVariable Long id_producto) {
		return pService.eliminarProducto(id_producto);
	}
	
	@PostMapping({"/autentica"})
	public UsuarioBean login(@RequestBody UsuarioBean ub) {
		return uService.autenticacion(ub);
	}
	
	@PostMapping("/uploadFotoProducto")
	public Producto uploadFotoProducto(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("producto_id") Long id) {
		return pService.uploadFoto(archivo, id);
	}
	
	
	@GetMapping("/downloadFotoProducto/{id_producto}")
	public FotoBean downloadFotoProducto(@PathVariable Long id_producto) throws SQLException {
		return pService.downloadFoto(id_producto);
	}
	
	@PostMapping({ "/pregistrarVenta" })
	public ResponseEntity<Iterable<DetalleVP>> registrarVenta(@RequestBody VentaBean vb) {
		Iterable<DetalleVP> list = vService.registrarVenta(vb);
		return list != null ? ResponseEntity.status(HttpStatus.CREATED).body(list)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	@GetMapping({"/mercadopago/{id}"})
	public RequestMPBean getRequestMercadoPago(@PathVariable Long id){
		return vService.getRequestMercadoPago(id);
	}
	
}
