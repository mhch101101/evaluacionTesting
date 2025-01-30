import { Component, Input } from '@angular/core';
import TipoSexo from '../../models/TipoSexo';
import Cliente from '../../models/Cliente';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ClienteService } from '../../services/cliente.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cliente-modal',
  templateUrl: './cliente-modal.component.html',
  styleUrl: './cliente-modal.component.css'
})
export class ClienteModalComponent {
  @Input() cliente: Cliente | undefined;
  @Input() tipoSexo: TipoSexo[] = [];

  constructor(public activeModal: NgbActiveModal, private clienteService: ClienteService) { }

  onSubmit(form: NgForm): void {
    if (form.valid && this.cliente) {
      this.clienteService.guardarCliente(this.cliente).subscribe(() => {
        this.activeModal.close(true);
      });
    } else {
      console.log('Formulario inválido');
    }
  }
}
