import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Cliente from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private apiUrl = 'http://localhost:8080/api/clientes';

  constructor(private http: HttpClient) { }

  listarClientes(cliente: Cliente): Observable<Cliente[]> {
    return this.http.post<Cliente[]>(`${this.apiUrl}/obtenerClientes`, cliente);
  }

  guardarCliente(cliente: Cliente): Observable<any> {
    return this.http.post(`${this.apiUrl}/guardarCliente`, cliente);
  }

  eliminarCliente(clienteId: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/eliminarCliente`, { clienteId });
  }
}
