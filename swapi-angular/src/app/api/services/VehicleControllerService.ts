/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import type { VehicleDTO } from '../models/VehicleDTO';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class VehicleControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Returns the vehicle to the ID
     * @param id
     * @returns VehicleDTO Everything works fine
     * @throws ApiError
     */
    public getVehicle(
        id: string,
    ): Observable<VehicleDTO> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/vehicles/get',
            query: {
                'id': id,
            },
            errors: {
                400: `Invalid id supplied`,
                404: `there is no vehicle for given id`,
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
