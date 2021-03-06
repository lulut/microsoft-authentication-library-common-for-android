// Copyright (c) Microsoft Corporation.
// All rights reserved.
//
// This code is licensed under the MIT License.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
package com.microsoft.identity.common.internal.providers.oauth2;

import com.microsoft.identity.common.internal.logging.Logger;

/**
 * Holds the request of a token request.  The request will either contain the success result or the error result.
 */
public class TokenResult {

    private static final String TAG = TokenResult.class.getSimpleName();

    private TokenResponse mTokenResponse;
    private TokenErrorResponse mTokenErrorResponse;
    private boolean mSuccess = false;

    /**
     * Constructor of TokenResult.
     *
     * @param response      TokenResponse
     * @param errorResponse TokenErrorResponse
     */
    public TokenResult(final TokenResponse response, final TokenErrorResponse errorResponse) {
        Logger.verbose(TAG, "Init: " + TAG);
        this.mTokenResponse = response;
        this.mTokenErrorResponse = errorResponse;

        if (response != null) {
            mSuccess = true;
        }

    }

    /**
     * Returns the TokenResponse (success) associated with the request.
     *
     * @return TokenResponse
     */
    public TokenResponse getTokenResponse() {
        return mTokenResponse;
    }

    /**
     * Returns the TokenErrorResponse associated with the request.
     *
     * @return TokenErrorResponse
     */
    public TokenErrorResponse getErrorResponse() {
        return mTokenErrorResponse;
    }

    /**
     * Returns whether the token request was successful or not.
     *
     * @return boolean
     */
    public boolean getSuccess() {
        return mSuccess;
    }

    //CHECKSTYLE:OFF
    @Override
    public String toString() {
        return "TokenResult{" +
                "mTokenResponse=" + mTokenResponse +
                ", mTokenErrorResponse=" + mTokenErrorResponse +
                ", mSuccess=" + mSuccess +
                '}';
    }
    //CHECKSTYLE:ON

}
