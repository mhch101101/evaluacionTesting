import { Component } from '@angular/core';
import Cliente from '../../models/Cliente';
import { ClienteService } from '../../services/cliente.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import TipoSexo from '../../models/TipoSexo';
import { TipoSexoService } from '../../services/tipo-sexo.service';
import { ClienteModalComponent } from '../cliente-modal/cliente-modal.component';

@Component({
  selector: 'app-cliente-grilla',
  imports: [],
  templateUrl: './cliente-grilla.component.html',
  styleUrl: './cliente-grilla.component.css'
})
export class ClienteGrillaComponent {
  clientes: Cliente[] = [];
  tipoSexo: TipoSexo[] = [];
  filtro: Cliente = {};

  constructor(private clienteService: ClienteService, private tipoSexoService: TipoSexoService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.cargarClientes();
    this.cargarCombo();
  }
  cargarCombo(): void {
    this.tipoSexoService.listar().subscribe(data => {
      this.tipoSexo = data;
    });
  }
  cargarClientes(): void {
    this.clienteService.listarClientes(this.filtro).subscribe(data => {
      this.clientes = data;
    });
  }

  buscar(): void {
    this.cargarClientes();
  }

  abrirModal(cliente?: Cliente): void {
    const modalRef = this.modalService.open(ClienteModalComponent);
    modalRef.componentInstance.cliente = cliente;
    modalRef.componentInstance.tipoSexo = this.tipoSexo;
    modalRef.result.then((result) => {
      if (result) {
        this.cargarClientes();
      }
    }).catch(() => { });
  }

  eliminar(clienteId: number): void {
    const confirmar = confirm('¿Estás seguro de que deseas eliminar este cliente?');

    if (confirmar) {
      this.clienteService.eliminarCliente(clienteId).subscribe(() => {
        this.cargarClientes();
      });
    }
  }
}
