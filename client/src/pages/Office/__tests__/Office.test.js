import React from 'react';
import { render} from '@testing-library/react';
import Office from '../Office';
import '@testing-library/jest-dom';


test('officePage renders loading state', () => {
    const { container } = render(<Office />);
    const loadingElement = container.querySelector('.MuiCircularProgress-root');
    expect(loadingElement).toBeInTheDocument();
});

