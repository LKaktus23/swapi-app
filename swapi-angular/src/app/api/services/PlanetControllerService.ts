/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import type { PlanetDTO } from '../models/PlanetDTO';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class PlanetControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Returns the planet to the ID
     * @param id
     * @returns PlanetDTO Everything works fine
     * @throws ApiError
     */
    public getPlanet(
        id: string,
    ): Observable<PlanetDTO> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/planets/get',
            query: {
                'id': id,
            },
            errors: {
                400: `Invalid id supplied`,
                404: `there is no planet for given id`,
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
