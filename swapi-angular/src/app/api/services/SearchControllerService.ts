/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class SearchControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Get all available items
     * @returns string Everything works fine
     * @throws ApiError
     */
    public getAllSearchItems(): Observable<string> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/search/getAll',
            errors: {
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
