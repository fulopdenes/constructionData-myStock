import React from 'react';
import renderer from 'react-test-renderer';
import HomePage from '../HomePage';
test('homePage renders correctly', () => {
    const component = renderer.create(<HomePage />);
    const tree = component.toJSON();
    expect(tree).toMatchSnapshot();
});